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
                description = "Bună. Numele meu este Alexy și împreună vom face puțină mișcare! Dacă ești la început te rog să lucrezi ușor! \n" +
                        "În timpul exercițiilor ține abdomenul încordat. \n" +
                        "La semiflotare coatele merg în diagonală, fesele sunt bine încordate, stând paralele cu solul. Dacă poți, fă flotările din picioare. \n" +
                        "La genoflexiuni, trebuie să ții picioarele la nivelul umerilor și vârfurile puțin deschise spre exterior. În momentul în care cobori, fesele sunt cele care coboară primele, nu lăsa presiunea pe genunchi. \n" +
                        "Inspiră pe nas, expiră pe gură și fă pauze de apă(20-30 secunde). \n" +
                        "Varianta mai ușoară la exercițiul cu rostogolirea(min 19) este să ții picioarele îndoite. Poziția spatelui să fie mereu cu umerii trași în față și abdomenul bine încordat în interior. \n" +
                        "La fandări, pasul cât mai mare iar genunchiul nu depășește vârful degetelor. \n" +
                        "Pentru exercițiile la sol vei avea nevoie de o saltea sau ceva pe care te simți comod."
            }
            2 -> {
                description = ""


            }
            3 -> {
                description = "Încordează bine abdomenul în timpul exercițiilor. \n" +
                        "Strânge bine pumnii și lovește cu fortă. \n" +
                        "La abdomene ai grijă la poziția spatelui, abdomenul trebuie să fie băgat în interior, lombarii lipiți de podea, gâtul în sus, umerii ridicați și pieptul în față."
            }
        }
        return description
    }
}