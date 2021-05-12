package com.example.workouthome.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouthome.R
import com.example.workouthome.adapters.DayNutritionAdapter
import com.example.workouthome.databinding.FragmentDayNutritionBinding
import com.example.workouthome.modules.DayNutritionItem
import com.example.workouthome.utils.Constants.DAY_NUMBER
import com.example.workouthome.viewmodel.NutritionTypeViewModel

@Suppress("DEPRECATION")
class DayNutritionFragment : Fragment(R.layout.fragment_day_nutrition) {

    private var nutritionList: ArrayList<DayNutritionItem> = ArrayList()
    private var dayNutritionAdapter: DayNutritionAdapter? = null
    private var dayNumber: Int = 0

    private  var _binding: FragmentDayNutritionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            dayNumber = this.getInt(DAY_NUMBER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adviceTypeViewModel = NutritionTypeViewModel(activity)
        super.onViewCreated(view, savedInstanceState)

        nutritionList = adviceTypeViewModel.setDayNutritionList("calories_level_1", dayNumber)

        // set first item selected by default.
        if (savedInstanceState == null) {
            _binding?.chipNavBar?.setItemSelected((R.id.calories_level_1))
        }

        _binding?.chipNavBar?.setOnItemSelectedListener {
            when (it) {
                R.id.calories_level_1 -> {
                    nutritionList =
                        adviceTypeViewModel.setDayNutritionList("calories_level_1", dayNumber)
                    dayNutritionAdapter?.updateItems(nutritionList)
                }
                R.id.calories_level_2 -> {
                    nutritionList =
                        adviceTypeViewModel.setDayNutritionList("calories_level_2", dayNumber)
                    dayNutritionAdapter?.updateItems(nutritionList)
                }
                R.id.calories_level_3 -> {
                    nutritionList =
                        adviceTypeViewModel.setDayNutritionList("calories_level_3", dayNumber)
                    dayNutritionAdapter?.updateItems(nutritionList)
                }
                R.id.vegetarian_level -> {
                    nutritionList =
                        adviceTypeViewModel.setDayNutritionList("vegetarian_level", dayNumber)
                    dayNutritionAdapter?.updateItems(nutritionList)
                }
            }
            true
        }

        _binding?.dayNutritionRv?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        _binding?.dayNutritionRv?.setHasFixedSize(true)

        dayNutritionAdapter = DayNutritionAdapter(activity, nutritionList)
        _binding?.dayNutritionRv?.adapter = dayNutritionAdapter
    }
}