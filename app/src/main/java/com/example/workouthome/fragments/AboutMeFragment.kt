package com.example.workouthome.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.workouthome.R
import com.example.workouthome.adapters.AboutMeAdapter
import com.example.workouthome.databinding.FragmentAboutMeBinding
import com.example.workouthome.firebase.FirestoreClass
import com.example.workouthome.modules.User
import com.example.workouthome.utils.Constants
import com.example.workouthome.utils.UiUtils.hideProgressDialog
import com.example.workouthome.utils.UiUtils.showProgressDialog
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_about_me.*
import java.io.IOException


class AboutMeFragment : Fragment(R.layout.fragment_about_me) {

    companion object {
        private const val READ_STORAGE_PERMISSION_CODE = 1
        private const val PICK_IMAGE_REQUEST_CODE = 2
        private const val TAG = "AboutMeFragment"
    }

    private  var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!

    private lateinit var aboutMeNames: List<String>
    private var mSelectedImageFileUri: Uri? = null

    // for save url
    private var mProfileImageURL: String = ""
    private lateinit var mUserDetails: User
    private lateinit var aboutMeAdapter: AboutMeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOf(
            getString(R.string.height),
            getString(R.string.weight),
            getString(R.string.desired_weight),
            getString(R.string.birthday),
            getString(R.string.gender)
        ).also { aboutMeNames = it }

        _binding?.aboutMeRv?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        _binding?.aboutMeRv?.adapter = AboutMeAdapter(aboutMeNames, requireActivity())
        aboutMeAdapter = about_me_rv.adapter as AboutMeAdapter


        // load data from firebase
        FirestoreClass().loadData(this)

        // update button
        _binding?.btnUpdate?.setOnClickListener {
            if (mSelectedImageFileUri != null) {
                uploadUserImage()
                FirestoreClass().loadUserData(requireActivity())
                Log.d(TAG, "Success update in nav view")
            } else {
                showProgressDialog(resources.getString(R.string.please_wait), requireContext())
                updateUserProfileData()
                FirestoreClass().loadUserData(requireActivity())
            }
        }

        // click on image and open gallery for choose image
        _binding?.imageProfile?.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                showImageChooser()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_STORAGE_PERMISSION_CODE
                )
            }
        }
    }

    // for request permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showImageChooser()
            } else {
                Toast.makeText(requireContext(), getString(R.string.permission_not_granted), Toast.LENGTH_LONG).show()
            }
        }
    }

    // start the screen for choose image from gallery
    private fun showImageChooser() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
    }

    // put the selected image from gallery in about me screen
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST_CODE && data!!.data != null) {
            mSelectedImageFileUri = data.data

            try {
                Glide
                    .with(this)
                    .load(mSelectedImageFileUri)
                    .centerCrop()
                    .placeholder(R.drawable.ic_user)
                    .into(image_profile)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    // set data from database in UI depending on position
    fun setUserDataInUI(user: User) {
        mUserDetails = user
        Glide
            .with(this)
            .load(user.image)
            .centerCrop()
            .placeholder(R.drawable.ic_user)
            .into(image_profile)

        if (::aboutMeAdapter.isInitialized) {
            for (i in 0 until aboutMeAdapter.itemCount) {
                val viewHolder =
                    _binding?.aboutMeRv?.findViewHolderForAdapterPosition(i) as AboutMeAdapter.AboutMeViewHolder
                when (i) {
                    0 -> {
                        viewHolder.aboutMeValue.text = user.height
                    }
                    1 -> {
                        viewHolder.aboutMeValue.text = user.weight
                    }
                    2 -> {
                        viewHolder.aboutMeValue.text = user.desiredWeight
                    }
                    3 -> {
                        viewHolder.aboutMeValue.text = user.dateOfBirth
                    }
                    4 -> {
                        viewHolder.aboutMeValue.text = user.gender
                    }
                }
            }
        } else {
            Log.e(TAG, getString(R.string.adapter_initialized))
        }
    }

    // update user data in database
    private fun updateUserProfileData() {
        val userHashMap = HashMap<String, Any>()

        if (mProfileImageURL.isNotEmpty() && mProfileImageURL != mUserDetails.image) {
            userHashMap[getString(R.string.image)]
            userHashMap[Constants.IMAGE] = mProfileImageURL
        }

        for (i in 0 until aboutMeAdapter.itemCount) {
            val viewHolder =
                _binding?.aboutMeRv?.findViewHolderForAdapterPosition(i) as AboutMeAdapter.AboutMeViewHolder


            when (i) {
                0 -> {
                    if (viewHolder.aboutMeValue.text.toString() != mUserDetails.height) {
                        userHashMap[Constants.HEIGHT] = viewHolder.aboutMeValue.text.toString()
                    }
                }
                1 -> {
                    if (viewHolder.aboutMeValue.text.toString() != mUserDetails.weight) {
                        userHashMap[Constants.WEIGHT] = viewHolder.aboutMeValue.text.toString()
                    }
                }
                2 -> {
                    if (viewHolder.aboutMeValue.text.toString() != mUserDetails.desiredWeight) {
                        userHashMap[Constants.DESIREDWEIGHT] =
                            viewHolder.aboutMeValue.text.toString()
                    }
                }
                3 -> {
                    if (viewHolder.aboutMeValue.text.toString() != mUserDetails.dateOfBirth) {
                        userHashMap[Constants.DATEOFBIRTH] = viewHolder.aboutMeValue.text.toString()
                    }
                }
                4 -> {
                    if (viewHolder.aboutMeValue.text.toString() != mUserDetails.gender) {
                        userHashMap[Constants.GENDER] = viewHolder.aboutMeValue.text.toString()
                    }
                }
            }

            FirestoreClass().updateUserProfileData(AboutMeFragment(), userHashMap)
        }
    }

    // upload user image in firebase
    private fun uploadUserImage() {
        showProgressDialog(resources.getString(R.string.please_wait), requireContext())

        if (mSelectedImageFileUri != null) {
            val sRef: StorageReference = FirebaseStorage.getInstance().reference.child(
                getString(R.string.user_image) + System.currentTimeMillis() + '.' + getFileExtension(
                    mSelectedImageFileUri
                )
            )

            sRef.putFile(mSelectedImageFileUri!!).addOnSuccessListener { taskSnapshot ->

                // for take the link and put in database
                taskSnapshot.metadata!!.reference!!.downloadUrl.addOnSuccessListener { uri ->
                    mProfileImageURL = uri.toString()

                    hideProgressDialog()

                    updateUserProfileData()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(requireContext(), exception.message, Toast.LENGTH_SHORT).show()

                hideProgressDialog()
            }
        }
    }

    // close wait dialog
    fun profileUpdateSuccess() {
        hideProgressDialog()
        activity?.setResult(Activity.RESULT_OK)
        activity?.finish()
    }

    // get the uri and return the type of extension
    private fun getFileExtension(uri: Uri?): String? {
        val resolver = requireActivity().contentResolver
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(resolver.getType(uri!!))
    }
}