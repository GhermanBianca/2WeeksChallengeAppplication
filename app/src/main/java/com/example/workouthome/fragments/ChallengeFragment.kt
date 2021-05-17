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
import com.example.workouthome.modules.ChallengeItem

class ChallengeFragment : Fragment(R.layout.fragment_challenge) {

    private var challengeItem: ArrayList<ChallengeItem>? = null
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

        challengeItem = ArrayList()
        challengeItem = setChallengeList()
        challengeAdapter = ChallengeAdapter(activity, challengeItem!!)
        _binding?.challengeRv?.adapter = challengeAdapter
    }

    private fun setChallengeList() : ArrayList<ChallengeItem> {
        val challengeArrayList: ArrayList<ChallengeItem> = ArrayList()

        challengeArrayList.add(ChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.buttocks_abs), R.drawable.buttock))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.cardio), R.drawable.cardio_fight))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.yoga), R.drawable.yoga))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.relax), R.drawable.relax))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.cardio), R.drawable.cardio_fight))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.fullbody), R.drawable.full_body))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.buttock_thigs), R.drawable.buttock_twigh))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.yoga), R.drawable.yoga))
        challengeArrayList.add(ChallengeItem(resources.getString(R.string.relax), R.drawable.relax))

        return challengeArrayList
    }
}