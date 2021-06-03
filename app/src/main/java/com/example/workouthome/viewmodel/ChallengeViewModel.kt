package com.example.workouthome.viewmodel

import androidx.fragment.app.FragmentActivity
import com.example.workouthome.R

class ChallengeViewModel(private val fragmentActivity: FragmentActivity?) {
    // set path for every video
    fun setChallengeVideo(dayNumber: Int): String {
        var videoPath = ""
        when (dayNumber) {
            1 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day1
            }
            2 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            3 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day3
            }
            4 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day4
            }
            5 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day5
            }
            6 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day6
            }
            7 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            8 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            9 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            10 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day10
            }
            11 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.day11
            }
        }
        return videoPath
    }

    // set description for every video
    fun setChallengeDescription(dayNumber: Int): String {
        var description = ""
        when (dayNumber) {
            1 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_1)
            }
            2 -> {
                description = ""


            }
            3 -> {
                description =  fragmentActivity!!.getString(R.string.description_challenge_day_3)
            }

            4 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_4)
            }
            5 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_5)
            }
            6 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_6)
            }
            7 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_7)
            }

            8 -> {
                description = ""
            }
            9 -> {
                description = ""
            }
            10 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_10)
            }
            11 -> {
                description = fragmentActivity!!.getString(R.string.description_challenge_day_11)

            }
        }
        return description
    }
}