package com.example.workouthome.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentSettingsBinding
import com.example.workouthome.utils.SharedPref.insertIntoSharedPrefs
import java.util.*

@Suppress("DEPRECATION")
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val listLanguages = arrayOf(ROMANIAN, ENGLISH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        Log.d("abab", "SettingsFragment onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("abab", "SettingsFragment onViewCreated")

        val result: Int

        val settings = context?.getSharedPreferences(RESTORE_VALUES, Context.MODE_PRIVATE)
        result = settings?.getInt(ON_PAUSE, -1)!!

        Log.d("abab","on view Created result $result")

        if (result == 0) {
            val languageCode = Locale.getDefault().displayLanguage
            setDefaultLanguage(languageCode)
            _binding?.selectedLanguage?.text = languageCode.capitalize(Locale.ROOT)

            val settings1 = context?.getSharedPreferences(RESTORE_VALUES, Context.MODE_PRIVATE)
            val e = settings1!!.edit()
            e.clear()
            e.putInt(ON_PAUSE, -1)
            e.apply()

        } else {
            retrieveFromSharedPrefs()
        }

        _binding?.cardChangeLanguage?.setOnClickListener {
            showChangeLanguage()
        }
    }

    private fun setDefaultLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config: Configuration? = activity?.resources?.configuration
        config?.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
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
                val action = SettingsFragmentDirections.actionSettingsFragmentToSplashScreenActivity()
                findNavController().navigate(action)
            } else if (which == 1) {
                setLocale(requireActivity(), EN)
                val action = SettingsFragmentDirections.actionSettingsFragmentToSplashScreenActivity()
                findNavController().navigate(action)
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()
    }

    private fun setLocale(activity: FragmentActivity, languageCode: String) {
        val locale = Locale(languageCode)
        Log.d("abab", "actual language $locale")
        Locale.setDefault(locale)
        val config: Configuration = activity.resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    override fun onDestroy() {
        Log.d("abab", "SettingsFragment onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val WHICH = "which"
        private const val ON_PAUSE = "on_pause"
        private const val RO = "ro"
        private const val EN = "en"
        private const val ROMANIAN = "Română"
        private const val ENGLISH = "English"
        private const val RESTORE_VALUES = "restore_values"
    }
}