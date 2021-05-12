package com.example.workouthome.firebase

import com.google.firebase.auth.FirebaseAuth

class FirebaseUtils {

    companion object {
        // This is used in Splash Activity for auto login
        fun getCurrentUserId() : String {
            val currentUser = FirebaseAuth.getInstance().currentUser
            var currentUserID = ""
            if(currentUser != null) {
                currentUserID = currentUser.uid
            }
            return currentUserID
        }
    }
}