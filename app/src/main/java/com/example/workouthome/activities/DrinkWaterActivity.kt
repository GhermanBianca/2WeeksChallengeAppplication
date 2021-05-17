package com.example.workouthome.activities

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.workouthome.R
import kotlinx.android.synthetic.main.activity_drink_water.*

class DrinkWaterActivity : AppCompatActivity() {

    private var isChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_water)

        // for show app full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setupActionBar()

        val checkAnim = findViewById<LottieAnimationView>(R.id.checkbox_water)
        checkAnim.setMinFrame(20)
        checkAnim.setMaxFrame(50)

        checkAnim.setOnClickListener {
            if(isChecked) {
                checkAnim.speed = 1f
                checkAnim.playAnimation()
                isChecked= true
            } else {
                checkAnim.speed = -1f
                checkAnim.playAnimation()
                isChecked= false
            }
        }
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_drink_water)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        }
        toolbar_drink_water.setNavigationOnClickListener { onBackPressed() }
    }
}