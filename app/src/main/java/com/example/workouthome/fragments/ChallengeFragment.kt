package com.example.workouthome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workouthome.R
import com.example.workouthome.adapters.ChallengeAdapter
import com.example.workouthome.databinding.FragmentChallengeBinding
import com.example.workouthome.model.DayChallengeItem

class ChallengeFragment : Fragment(R.layout.fragment_challenge) {

    private var dayChallengeItem: ArrayList<DayChallengeItem>? = null
    private var challengeAdapter : ChallengeAdapter? = null
    private var gridLayoutManagerNutrition: GridLayoutManager? = null

    private  var _binding: FragmentChallengeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChallengeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        gridLayoutManagerNutrition = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)

        _binding?.challengeRv?.layoutManager = gridLayoutManagerNutrition
        _binding?.challengeRv?.setHasFixedSize(true)

        dayChallengeItem = ArrayList()
        dayChallengeItem = setChallengeList()
        challengeAdapter = ChallengeAdapter(activity, dayChallengeItem!!)
        _binding?.challengeRv?.adapter = challengeAdapter
    }

    private fun setChallengeList() : ArrayList<DayChallengeItem> {
        val dayChallengeArrayList: ArrayList<DayChallengeItem> = ArrayList()

        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.buttocks_abs), R.drawable.buttock))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.cardio), R.drawable.cardio_fight))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.yoga), R.drawable.yoga))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.relax), R.drawable.relax))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.cardio), R.drawable.cardio_fight))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.yoga), R.drawable.yoga))
        dayChallengeArrayList.add(DayChallengeItem(resources.getString(R.string.relax), R.drawable.relax))

        return dayChallengeArrayList
    }
}