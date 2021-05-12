package com.example.workouthome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouthome.R
import com.example.workouthome.adapters.NutritionAdapter
import com.example.workouthome.databinding.FragmentNutritionBinding

class NutritionFragment : Fragment(R.layout.fragment_nutrition) {

    private var daysList: ArrayList<Int>? = null
    private var gridLayoutManagerNutrition: GridLayoutManager? = null
    private var nutritionAdapter: NutritionAdapter? = null

    private  var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridLayoutManagerNutrition = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false)
        _binding?.nutritionRv?.layoutManager = gridLayoutManagerNutrition
        _binding?.nutritionRv?.setHasFixedSize(true)
        daysList = setDayList()

        nutritionAdapter = NutritionAdapter(requireActivity(), daysList!!)
        _binding?.nutritionRv?.adapter = nutritionAdapter
    }

    private fun setDayList(): ArrayList<Int> {
        val arrayList :ArrayList<Int> = ArrayList()

        for (i in 1..14) {
            arrayList.add(i)
        }
        return arrayList
    }
}
