package com.example.workouthome.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentSettingsBinding
import com.example.workouthome.utils.SharedPref.insertIntoSharedPrefs
import java.util.*

@Suppress("DEPRECATION")
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    companion object {
        private const val WHICH = "which"
        private const val RO = "ro"
        private const val EN = "en"
        private const val ROMANIAN = "Română"
        private const val ENGLISH = "English"
    }

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    val listLanguages = arrayOf(ROMANIAN, ENGLISH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrieveFromSharedPrefs()

        _binding?.cardChangeLanguage?.setOnClickListener {
            showChangeLanguage()
        }
    }

    private fun retrieveFromSharedPrefs(): Int? {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val savedWhich = sharedPref?.getInt(WHICH, 0)

        if (savedWhich == 0) {
            _binding?.selectedLanguage?.text = resources.getString(R.string.romanian)
        } else {
            _binding?.selectedLanguage?.text = resources.getString(R.string.english)
        }

        return savedWhich
    }

    private fun showChangeLanguage() {

        val mBuilder = AlertDialog.Builder(requireContext())
        mBuilder.setTitle(resources.getString(R.string.choose_language))
        mBuilder.setSingleChoiceItems(listLanguages, -1) { dialog, which ->

            insertIntoSharedPrefs(which, requireActivity())

            Log.d("abab", "showChangeLanguage which == $which"  )

            if (which == 0) {
                setLocale(requireActivity(), RO)
                recreate(requireActivity())
            } else if (which == 1) {
                setLocale(requireActivity(), EN)
                recreate(requireActivity())
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()
    }

    private fun setLocale(activity: FragmentActivity, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config: Configuration = activity.resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}