package com.example.workouthome.utils

import android.content.Context
import androidx.fragment.app.FragmentActivity

object SharedPref {

    private const val WHICH = "which"

    fun insertIntoSharedPrefs(which: Int, activity: FragmentActivity ){
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putInt(WHICH, which)
            apply()
        }
    }
}