package com.example.workouthome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouthome.R
import com.example.workouthome.adapters.AdviceTypeAdapter
import com.example.workouthome.databinding.FragmentAdviceTypeBinding
import com.example.workouthome.modules.AdviceTypeItem
import com.example.workouthome.utils.Constants.DESCRIPTION_IMAGE
import com.example.workouthome.utils.Constants.DESCRIPTION_TYPE
import com.example.workouthome.viewmodel.AdviceTypeViewModel

class AdviceTypeFragment : Fragment(R.layout.fragment_advice_type) {

    private var adviceTypeItem: ArrayList<AdviceTypeItem>? = null
    private var adviceTypeAdapter: AdviceTypeAdapter? = null
    private var activityType: String? = null
    private var activityImage: Int? = null

    private  var _binding: FragmentAdviceTypeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            activityType = this.getString(DESCRIPTION_TYPE)
            activityImage = this.getInt(DESCRIPTION_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdviceTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.adviceTypeRv?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        _binding?.adviceTypeRv?.setHasFixedSize(true)

        adviceTypeItem = ArrayList()
        adviceTypeItem = setAdviceTypeList()
        adviceTypeAdapter = AdviceTypeAdapter(activity, adviceTypeItem!!)
        _binding?.adviceTypeRv?.adapter = adviceTypeAdapter

        _binding?.titleAdvice?.text = activityType.toString()
        _binding?.imageTypeAdvice?.setImageResource(activityImage!!)
    }

    private fun setAdviceTypeList(): ArrayList<AdviceTypeItem> {

        val adviceTypeViewModel = AdviceTypeViewModel(activity)

        return when (activityType) {
            getString(R.string.sport) -> {
                adviceTypeViewModel.getSportList()

            }
            getString(R.string.nutritions) -> {
                adviceTypeViewModel.getNutritionList()
            }
            getString(R.string.various) -> {
                adviceTypeViewModel.getVariousList()
            }
            else -> {
                adviceTypeViewModel.getSportList()
            }
        }
    }
}