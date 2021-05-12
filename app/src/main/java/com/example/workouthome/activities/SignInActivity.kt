package com.example.workouthome.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Log.d
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.example.workouthome.R
import com.example.workouthome.utils.UiUtils.hideProgressDialog
import com.example.workouthome.utils.UiUtils.showProgressDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

@Suppress("DEPRECATION")
class SignInActivity : BaseActivity() {
    companion object {
        private const val TAG = "SignInActivity"
    }

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()

        // for show app full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // press create sign in button
        btn_create_sign_in.setOnClickListener {
            signInRegisteredUser()
            Log.e(TAG, "Sign in button was pressed in Sign In Activity")
        }
        setupActionBar()
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_sign_in)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        }
        toolbar_sign_in.setNavigationOnClickListener { onBackPressed() }
    }

    private fun validateForm(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Te rog să introduci email-ul")
                Log.e(TAG, "Please enter email")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Te rog să introduci parola")
                Log.e(TAG, "Please enter password")
                false
            }
            else -> {
                return true
            }
        }
    }

    private fun signInRegisteredUser() {
        val email: String = et_email_sign_in.text.toString().trim { it <= ' ' }
        val password: String = et_password_sign_in.text.toString().trim { it <= ' ' }

        if (validateForm(email, password)) {
            showProgressDialog(resources.getString(R.string.please_wait), this)
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        d(TAG, "signInWithEmail:success")
                        auth.currentUser
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    fun signInSuccess() {
        hideProgressDialog()
        startActivity(Intent(this, MainActivity::class.java))
        Log.e(TAG, "The Main Activity was shown")
        finish()
    }
}