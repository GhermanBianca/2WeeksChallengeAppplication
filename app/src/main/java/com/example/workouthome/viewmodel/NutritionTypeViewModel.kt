package com.example.workouthome.viewmodel

import androidx.fragment.app.FragmentActivity
import com.example.workouthome.R
import com.example.workouthome.modules.DayNutritionItem

// for set nutrition list depending on day and level
class NutritionTypeViewModel(private val fragmentActivity: FragmentActivity?) {

    fun setDayNutritionList(type: String, dayNumber: Int): ArrayList<DayNutritionItem> {

        var breakfast = ""
        var snack1 = ""
        var lunch = ""
        var sneak2 = ""
        var dinner = ""

        val levelCaloriesOneList: ArrayList<DayNutritionItem> = ArrayList()
        when (dayNumber) {
            1 -> when (type) {
                "calories_level_1" -> {
                    breakfast = fragmentActivity!!.getString(R.string.breakfast_dayone_level_one)
                    snack1 = fragmentActivity.getString(R.string.snack_dayone_level_one_first)
                    lunch = fragmentActivity.getString(R.string.lunch_dayone_level_one)
                    sneak2 = fragmentActivity.getString(R.string.snack_dayone_level_one_second)
                    dinner = fragmentActivity.getString(R.string.dinner_dayone_level_one)
                }
                "calories_level_2" -> {
                    breakfast = fragmentActivity!!.getString(R.string.breakfast_dayone_level_two)
                    snack1 = fragmentActivity.getString(R.string.snack_dayone_level_two_first)
                    lunch = fragmentActivity.getString(R.string.lunch_dayone_level_two)
                    sneak2 = fragmentActivity.getString(R.string.snack_dayone_level_two_second)
                    dinner = fragmentActivity.getString(R.string.dinner_dayone_level_two)
                }
                "calories_level_3" -> {
                    breakfast = fragmentActivity!!.getString(R.string.breakfast_dayone_level_three)
                    snack1 = fragmentActivity.getString(R.string.snack_dayone_level_three_first)
                    lunch = fragmentActivity.getString(R.string.lunch_dayone_level_three)
                    sneak2 = fragmentActivity.getString(R.string.snack_dayone_level_three_second)
                    dinner = fragmentActivity.getString(R.string.dinner_dayone_level_three)
                }
                "vegetarian_level" -> {
                    breakfast = fragmentActivity!!.getString(R.string.breakfast_dayone_vegetarian_level)
                    snack1 = fragmentActivity.getString(R.string.snack_dayone_vegetarian_level_first)
                    lunch = fragmentActivity.getString(R.string.lunch_dayone_vegetarian_level)
                    sneak2 = fragmentActivity.getString(R.string.snack_dayone_vegetarian_level_second)
                    dinner = fragmentActivity.getString(R.string.dinner_dayone_vegetarian_level)
                }
            }
            2 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwo_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwo_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwo_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwo_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwo_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwo_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwo_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwo_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwo_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwo_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwo_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwo_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwo_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwo_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwo_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwo_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwo_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwo_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwo_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwo_vegetarian_level)
                    }
                }
            }
            3 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythree_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daythree_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythree_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythree_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythree_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythree_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daythree_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythree_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythree_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythree_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythree_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daythree_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythree_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythree_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythree_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythree_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daythree_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythree_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythree_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythree_vegetarian_level)
                    }
                }
            }
            4 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfour_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfour_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfour_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfour_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfour_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfour_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfour_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfour_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfour_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfour_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfour_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfour_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfour_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfour_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfour_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfour_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfour_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfour_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfour_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfour_vegetarian_level)
                    }
                }
            }

            5 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfive_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfive_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfive_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfive_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfive_menu_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfive_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfive_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfive_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfive_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfive_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfive_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfive_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfive_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfive_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfive_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfive_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfive_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfive_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfive_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfive_vegetarian_level)
                    }
                }
            }

            6 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daysix_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daysix_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daysix_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daysix_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daysix_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daysix_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daysix_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daysix_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daysix_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daysix_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daysix_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daysix_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daysix_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daysix_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daysix_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daysix_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daysix_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daysix_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daysix_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daysix_vegetarian_level)
                    }
                }
            }

            7 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayseven_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayseven_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayseven_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayseven_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayseven_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayseven_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayseven_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayseven_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayseven_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayseven_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayseven_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayseven_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayseven_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayseven_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayseven_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayseven_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayseven_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayseven_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayseven_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayseven_vegetarian_level)
                    }
                }
            }

            8 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeight_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeight_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeight_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeight_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeight_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeight_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeight_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeight_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeight_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeight_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeight_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeight_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeight_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeight_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeight_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeight_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeight_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeight_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeight_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeight_vegetarian_level)
                    }
                }
            }

            9 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daynine_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daynine_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daynine_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daynine_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daynine_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daynine_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daynine_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daynine_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daynine_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daynine_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daynine_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daynine_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daynine_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daynine_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daynine_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daynine_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daynine_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daynine_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daynine_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daynine_vegetarian_level)
                    }
                }
            }

            10 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayten_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayten_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayten_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayten_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayten_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayten_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayten_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayten_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayten_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayten_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayten_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayten_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayten_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayten_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayten_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayten_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayten_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayten_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayten_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayten_vegetarian_level)
                    }
                }
            }

            11 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeleven_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeleven_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeleven_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeleven_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeleven_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeleven_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeleven_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeleven_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeleven_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeleven_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeleven_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeleven_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeleven_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeleven_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeleven_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayeleven_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayeleven_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayeleven_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayeleven_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayeleven_vegetarian_level)
                    }
                }
            }

            12 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwelve_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwelve_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwelve_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwelve_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwelve_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwelve_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwelve_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwelve_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwelve_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwelve_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwelve_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwelve_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwelve_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwelve_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwelve_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daytwelve_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daytwelve_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daytwelve_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daytwelve_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daytwelve_vegetarian_level)
                    }
                }
            }

            13 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythirteen_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_daythirteen_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythirteen_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythirteen_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythirteen_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythirteen_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_daythirteen_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythirteen_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythirteen_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythirteen_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythirteen_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_daythirteen_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythirteen_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythirteen_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythirteen_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_daythirteen_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_daythirteen_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_daythirteen_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_daythirteen_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_daythirteen_vegetarian_level)
                    }
                }
            }

            14 -> {
                when (type) {
                    "calories_level_1" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfourteen_level_one)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfourteen_level_one_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfourteen_level_one)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfourteen_level_one_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfourteen_level_one)
                    }
                    "calories_level_2" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfourteen_level_two)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfourteen_level_two_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfourteen_level_two)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfourteen_level_two_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfourteen_level_two)
                    }
                    "calories_level_3" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfourteen_level_three)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfourteen_level_three_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfourteen_level_three)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfourteen_level_three_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfourteen_level_three)
                    }
                    "vegetarian_level" -> {
                        breakfast = fragmentActivity!!.getString(R.string.breakfast_dayfourteen_vegetarian_level)
                        snack1 = fragmentActivity.getString(R.string.snack_dayfourteen_vegetarian_level_first)
                        lunch = fragmentActivity.getString(R.string.lunch_dayfourteen_vegetarian_level)
                        sneak2 = fragmentActivity.getString(R.string.snack_dayfourteen_vegetarian_level_second)
                        dinner = fragmentActivity.getString(R.string.dinner_dayfourteen_vegetarian_level)
                    }
                }
            }
        }

        levelCaloriesOneList.add(
            DayNutritionItem(
                R.drawable.breakfast,
                fragmentActivity!!.getString(R.string.breakfast_name),
                R.drawable.ic_circle,
                breakfast
            )
        )
        levelCaloriesOneList.add(
            DayNutritionItem(
                R.drawable.snack,
                fragmentActivity.getString(R.string.snack_name),
                R.drawable.ic_circle,
                snack1
            )
        )
        levelCaloriesOneList.add(
            DayNutritionItem(
                R.drawable.lunch,
                fragmentActivity.getString(R.string.lunch_name),
                R.drawable.ic_circle,
                lunch
            )
        )
        levelCaloriesOneList.add(
            DayNutritionItem(
                R.drawable.snack,
                fragmentActivity.getString(R.string.snack_name),
                R.drawable.ic_circle,
                sneak2
            )
        )
        levelCaloriesOneList.add(
            DayNutritionItem(
                R.drawable.dinner,
                fragmentActivity.getString(R.string.dinner_name),
                R.drawable.ic_circle,
                dinner
            )
        )

        return levelCaloriesOneList
    }
}