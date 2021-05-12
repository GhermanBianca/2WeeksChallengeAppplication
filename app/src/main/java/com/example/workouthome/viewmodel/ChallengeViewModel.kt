package com.example.workouthome.viewmodel

import com.example.workouthome.R

class ChallengeViewModel {
    fun setChallengeVideo(dayNumber: Int) : String {
        var videoPath = ""
        when (dayNumber) {
            1 -> {
                videoPath = "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            2 -> {
                videoPath = "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            3 -> {
                videoPath = "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android

            }
        }
        return videoPath
    }
}