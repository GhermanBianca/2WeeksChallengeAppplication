package com.example.workouthome.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import com.example.workouthome.R
import kotlinx.android.synthetic.main.activity_intro.*

@Suppress("DEPRECATION")
class IntroActivity : BaseActivity() {

    companion object {
        private const val TAG = "IntroActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        Log.e(TAG, "You are in Intro Activity now!")

        // for show app full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // press sign up button
        btn_sign_up.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            Log.e(TAG, "You pressed sign up button!")
        }

        //press sign in button
        btn_sign_in.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            Log.e(TAG, "You pressed sign in button!")
        }
    }
}