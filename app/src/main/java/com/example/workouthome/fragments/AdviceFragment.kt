package com.example.workouthome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouthome.R
import com.example.workouthome.adapters.AdviceAdapter
import com.example.workouthome.databinding.FragmentAdviceBinding
import com.example.workouthome.modules.AdviceItem
import kotlinx.android.synthetic.main.fragment_advice.*

class AdviceFragment : Fragment(R.layout.fragment_advice) {

    private var adviceItem: ArrayList<AdviceItem>? = null
    private var adviceAdapter: AdviceAdapter? = null

    private  var _binding: FragmentAdviceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdviceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.adviceRv?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        advice_rv?.setHasFixedSize(true)

        adviceItem = ArrayList()
        adviceItem = setAdviceList()
        adviceAdapter = AdviceAdapter(activity, adviceItem!!)
        _binding?.adviceRv?.adapter = adviceAdapter
    }

    private fun setAdviceList(): ArrayList<AdviceItem> {

        val arrayList: ArrayList<AdviceItem> = ArrayList()

        arrayList.add(AdviceItem(getString(R.string.sport), R.drawable.fitness_advice))
        arrayList.add(AdviceItem(getString(R.string.nutritions), R.drawable.nutrition_advice))
        arrayList.add(AdviceItem(getString(R.string.various), R.drawable.divers_advice))

        return arrayList
    }
}