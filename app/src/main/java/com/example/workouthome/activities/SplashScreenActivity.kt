package com.example.workouthome.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.workouthome.R
import com.example.workouthome.firebase.FirebaseUtils.Companion.getCurrentUserId

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val backgroundTextView: ImageView = findViewById(R.id.left_bottom_image)
        val slideAnimation = AnimationUtils.loadAnimation(
            this,
            R.anim.side_slide
        )
        backgroundTextView.startAnimation(slideAnimation)

        //This is for auto login
        Handler().postDelayed({
            if(getCurrentUserId().isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, IntroActivity::class.java))
            }
            finish()
        }, 1) // change with 3000 when  finish app

         //This is for always login
//        Handler().postDelayed({
//            startActivity(Intent(this, IntroActivity::class.java))
//            finish()
//        }, 3000)
    }
}
