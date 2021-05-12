package com.example.workouthome.firebase

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.workouthome.activities.MainActivity
import com.example.workouthome.activities.SignInActivity
import com.example.workouthome.activities.SignUpActivity
import com.example.workouthome.firebase.FirebaseUtils.Companion.getCurrentUserId
import com.example.workouthome.fragments.AboutMeFragment
import com.example.workouthome.modules.User
import com.example.workouthome.utils.Constants
import com.example.workouthome.utils.UiUtils.hideProgressDialog
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {

    companion object {
        private const val TAG = "FirestoreClass"
    }

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId()).set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener {
            }
    }

    // for load data in mainActivity and signActivity
    fun loadUserData(activity: Activity) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)!!
                document.toObject(User::class.java)!!

                when (activity) {
                    is SignInActivity -> {
                        activity.signInSuccess()
                    }
                    is MainActivity -> {
                        MainActivity.updateNavigationUserDetails(activity, loggedInUser)
                    }
                }
            }
            .addOnFailureListener { e ->

                when (activity) {
                    is SignInActivity -> {
                        hideProgressDialog()
                    }
                    is MainActivity -> {
                        hideProgressDialog()
                    }
                }
                Log.e(TAG, "A apărut o eroare în momentul preluării datelor user-ului conectat.", e)
            }
    }

    // load data from database
    fun loadData(fragment: Fragment) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)!!
                document.toObject(User::class.java)!!

                when (fragment) {
                    is AboutMeFragment -> {
                        fragment.setUserDataInUI(loggedInUser)
                    }
                }
            }
    }

    // update profile in UI
    fun updateUserProfileData(fragment: AboutMeFragment, userHashMap: HashMap<String, Any>) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .update(userHashMap)
            .addOnSuccessListener {
                Log.i(TAG, "Profile Data updated success!")
               // Toast.makeText(fragment.context, "Profilul a fost modificat cu success!", Toast.LENGTH_SHORT).show()
                fragment.profileUpdateSuccess()

            }.addOnFailureListener { e ->
                hideProgressDialog()
                Log.e(TAG, "Error when updating the profile!", e)
                //Toast.makeText(fragment.context, "A ap[rut o eroare în momentul modificării profilului!", Toast.LENGTH_SHORT).show()
            }
    }
}