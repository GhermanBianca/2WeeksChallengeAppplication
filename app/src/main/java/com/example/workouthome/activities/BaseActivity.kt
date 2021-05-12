package com.example.workouthome.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.workouthome.R
import com.google.android.material.snackbar.Snackbar

@Suppress("DEPRECATION")
open class BaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "BaseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    // show a snackBar if you don't complete all fiels
    fun showErrorSnackBar(message: String) {
        Log.e(TAG, "You don't complete every fields!")
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.snackbar_error_color))
        snackBar.show()
    }
}