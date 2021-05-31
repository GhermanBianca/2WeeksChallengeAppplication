package com.example.workouthome.viewmodel

import com.example.workouthome.R

class ChallengeViewModel {
    // set path for every video
    fun setChallengeVideo(dayNumber: Int): String {
        var videoPath = ""
        when (dayNumber) {
            1 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            2 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            3 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
        }
        return videoPath
    }

    // set description for every video
    fun setChallengeDescription(dayNumber: Int): String {
        var description = ""
        when (dayNumber) {
            1 -> {
                description = "aaa"
            }
            2 -> {
                description = "bbb"

            }
            3 -> {
                description = "ccc"

            }
        }
        return description
    }
}