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
            4 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            5 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            6 -> {
                videoPath =
                    "android.resource://" + "com.example.workouthome" + "/" + R.raw.test_android
            }
            7 -> {
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
                        "Varianta mai ușoară la exercițiul cu rostogolirea este să ții picioarele îndoite. Poziția spatelui să fie mereu cu umerii trași în față și abdomenul bine încordat în interior. \n" +
                        "La fandări, pasul cât mai mare iar genunchiul nu depășește vârful degetelor. \n" +
                        "Pentru exercițiile la sol vei avea nevoie de o saltea sau ceva pe care te simți comod."
            }
            2 -> {
                description = ""


            }
            3 -> {
                description = "Încordează bine abdomenul în timpul exercițiilor. \n" +
                        "Strânge bine pumnii și lovește cu forță. \n" +
                        "La abdomene ai grijă la poziția spatelui, abdomenul trebuie să fie băgat în interior, lombarii lipiți de podea, gâtul în sus, umerii ridicați și pieptul în față. \n" +
                        "Nu uita să faci pauze pentru a bea apă! \n" +
                        "Ține mereu abdomenul încordat!"
            }

            4 -> {
                description = "Dacă ești avansat, te rog să faci exercițiile cu greutăți. \n " +
                        "La genoflexiuni fesele merg mereu în spate, vârfurile picioarelor sunt perfect deschise, genunchii în exterior iar coloana dreaptă. \n" +
                        "La flotări, varianta ușoară este din genunchi. \n" +
                        "Nu uita să faci pauze pentru a bea apă! \n" +
                        "Ține mereu abdomenul încordat!"
            }
            5 -> {
                description = "La exercițiul din minutul 3 ține vârfurile puțin în diagonală, spatele drept, fesele mult în spate și fă pași laterali cu lovitură. \n " +
                        "La exercițiile de fight ține abdomenul încordat și pumnul strâns.\n" +
                        "La fandări, unghiul trebuie să fie de 90 de grade, spatele să nu fie cocoșat, ci în forma lui naturală perpendiculară, iar la ridicare încordează fesele. \n" +
                        "Dacă nu ai benzi de fese poți face fără, dar îți recomand să îți cumperi pentru rezultate garantate. \n" +
                        "Nu uita să faci pauze pentru a bea apă! \n" +
                        "Ține mereu abdomenul încordat!"
            }
            6 -> {
                description = "Termenul ‘Yoga’ este derivat din rădăcina Sanskrită ‘yuj’, care înseamă uniune - uniunea dintre corp, minte şi spirit sau conştiinţă. Este un mod de a uni diferite aspecte a ceea ce suntem noi. \n" +
                        "Yoga reduce stresul și anxietatea, implicit efectele fizice ale stresului asupra organismului. \n" +
                        "Yoga îmbunătățește flexibilitatea și echilibrul, dar crește și puterea mușchilor. \n" +
                        "Yoga poate reduce inflamațiile din corp și poate îmbunătăți sănătatea inimii. \n"
            }
            7 -> {
                description = ""
            }

            8 -> {
                description = ""
            }
            9 -> {
                description = ""
            }
            10 -> {
                description = "La exercițiile pe care le consider cu o dificultate mai ridicată întotdeauna vei avea și o variantă mai ușoară. \n" +
                        "La exercițiul de la minutul 21 varianta ușoară este din genunchi. \n" +
                        "La exercițiile pentru fesieri, cele la sol, dacă nu ai benzi poți să pui sticle de apă pe tine. \n" +
                        "Varianta ușoară la bicicletă este cu atingere jos. \n" +
                        "La exercițiul din minutul 30 varianta ușoară este cu coborârea picioarelor cu unghi de 45 de grade, iar important este să ai spatele bine lipit de podea. \n" +
                        "Începând cu minutul 35 vom începe să ne relaxăm, poți închide din lumini dacă dorești. Pune-te într-o poziție comodă, inspiră și expiră de 3 ori, ține palmele relaxate."
            }
        }
        return description
    }
}