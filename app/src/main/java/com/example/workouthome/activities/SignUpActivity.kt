package com.example.workouthome.activities

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.example.workouthome.R
import com.example.workouthome.firebase.FirestoreClass
import com.example.workouthome.modules.User
import com.example.workouthome.utils.UiUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_up.*

@Suppress("DEPRECATION")
class SignUpActivity : BaseActivity() {
    companion object {
        private const val TAG = "SignUpActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // for show app full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setupActionBar()
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_sign_up)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        }

        toolbar_sign_up.setNavigationOnClickListener { onBackPressed() }

        btn_create_sign_up.setOnClickListener {
            registerUser()
            Log.e(TAG, "You pressed sign up button in Sign Up Activity!")
        }
    }

    private fun validateForm(
        name: String,
        email: String,
        password: String,
        confirmPasswod: String
    ): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Te rog să introduci numele")
                Log.e(TAG, "Please enter name")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Te rog să introduci email-ul")
                Log.e(TAG, "Please enter email")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Te rog să introduci parola")
                Log.e(TAG, "Please enter pasword")
                false
            }
            TextUtils.isEmpty(confirmPasswod) -> {
                showErrorSnackBar("Te rog să confirmi parola")
                Log.e(TAG, "Please confirm pasword")
                false
            }
            else -> {
                return true
            }
        }
    }

    private fun registerUser() {
        val name: String = et_name_sign_up.text.toString().trim { it <= ' ' }
        val email: String = et_email_sign_up.text.toString().trim { it <= ' ' }
        val password: String = et_password_sign_up.text.toString().trim { it <= ' ' }
        val confirmPasswod: String = et_confirm_password.text.toString().trim { it <= ' ' }

        if (validateForm(name, email, password, confirmPasswod)) {
            UiUtils.showProgressDialog(resources.getString(R.string.please_wait), this)
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        val user = User(firebaseUser.uid, name, registeredEmail)
                        FirestoreClass().registerUser(this, user)
                    } else {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Înregistrare eșuată!",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e(TAG, "Registration failed in SignUp!")
                    }
                }
        }
    }

    fun userRegisteredSuccess() {
        Toast.makeText(
            this@SignUpActivity,
            "Te-ai înregistrat cu succes.",
            Toast.LENGTH_SHORT
        ).show()
        UiUtils.hideProgressDialog()
        Log.e(TAG, "The please wait dialog was closed")
        FirebaseAuth.getInstance().signOut()
        finish()
        Log.e(TAG, "Sign Up activity was closed")
    }
}