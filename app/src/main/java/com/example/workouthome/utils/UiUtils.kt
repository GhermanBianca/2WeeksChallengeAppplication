package com.example.workouthome.utils

import android.app.Dialog
import android.content.Context
import android.util.Log
import com.example.workouthome.R
import kotlinx.android.synthetic.main.dialog_progress.*

object UiUtils {

    private lateinit var mProgressDialog: Dialog

    fun showProgressDialog(text: String, context: Context) {

        mProgressDialog = Dialog(context)

        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.tv_progress_text.text = text

        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        if (::mProgressDialog.isInitialized) {
            mProgressDialog.dismiss()
        } else {
            Log.e("UiUtils", "mProgressDialog should be initialized")
        }
    }
}