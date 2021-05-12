package com.example.workouthome.viewmodel

import androidx.fragment.app.FragmentActivity
import com.example.workouthome.R
import com.example.workouthome.modules.AdviceTypeItem

// set lists for advice types
class AdviceTypeViewModel(private val fragmentActivity: FragmentActivity?) {

    fun getSportList(): ArrayList<AdviceTypeItem> {

        val sportList = ArrayList<AdviceTypeItem>()

        sportList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.sport_advice_title_one),
                fragmentActivity?.getString(R.string.sport_advice_content_one)
            )
        )
        sportList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.sport_advice_title_two),
                fragmentActivity?.getString(R.string.sport_advice_content_two)
            )
        )
        sportList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.sport_advice_title_three),
                fragmentActivity?.getString(R.string.sport_advice_content_three)
            )
        )
        sportList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.sport_advice_title_four),
                fragmentActivity?.getString(R.string.sport_advice_content_four)
            )
        )

        return sportList
    }

    fun getNutritionList(): ArrayList<AdviceTypeItem> {

        val nutritionList = ArrayList<AdviceTypeItem>()

        nutritionList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.nutrition_advice_title_one),
                fragmentActivity?.getString(R.string.nutrition_advice_content_one)
            )
        )
        nutritionList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.nutrition_advice_title_two),
                fragmentActivity?.getString(R.string.nutrition_advice_content_two)
            )
        )
        nutritionList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.nutrition_advice_title_three),
                fragmentActivity?.getString(R.string.nutrition_advice_content_three)
            )
        )

        return nutritionList
    }

    fun getVariousList(): ArrayList<AdviceTypeItem> {

        val variousList = ArrayList<AdviceTypeItem>()

        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_one),
                fragmentActivity?.getString(R.string.various_advice_content_one)
            )
        )
        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_two),
                fragmentActivity?.getString(R.string.various_advice_content_two)
            )
        )
        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_three),
                fragmentActivity?.getString(R.string.various_advice_content_three)
            )
        )

        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_four),
                fragmentActivity?.getString(R.string.various_advice_content_four)
            )
        )

        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_five),
                fragmentActivity?.getString(R.string.various_advice_content_five)
            )
        )

        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_six),
                fragmentActivity?.getString(R.string.various_advice_content_six)
            )
        )

        variousList.add(
            AdviceTypeItem(
                fragmentActivity?.getString(R.string.various_advice_title_seven),
                fragmentActivity?.getString(R.string.various_advice_content_seven)
            )
        )

        return variousList
    }
}