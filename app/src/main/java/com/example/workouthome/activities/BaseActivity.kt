package com.example.workouthome.activities

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.workouthome.R
import com.example.workouthome.utils.ContextWrapper
import com.google.android.material.snackbar.Snackbar
import java.util.*

@Suppress("DEPRECATION")
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    // show a snackBar if you don't complete all fiels
    fun showErrorSnackBar(message: String) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.snackbar_error_color))
        snackBar.show()
    }

    // set device language
    override fun attachBaseContext(newBase: Context?) {
        val locale = Locale(Resources.getSystem().getConfiguration().locale.getLanguage())
        Locale.setDefault(locale)
        val context: Context = ContextWrapper.wrap(newBase, locale)
        super.attachBaseContext(context)
    }

    override fun onPause() {

        Log.d("abab", " onPause Base Activity" )

        saveCollection()

        super.onPause()
    }

    open fun saveCollection() {
        val settings = applicationContext.getSharedPreferences(RESTORE_VALUES, Context.MODE_PRIVATE)
        val e = settings.edit()
        e.clear()
        e.putInt(ON_PAUSE, 0)
        e.apply()
    }

    companion object {
        private const val ON_PAUSE = "on_pause"
        private const val RESTORE_VALUES = "restore_values"
    }
}