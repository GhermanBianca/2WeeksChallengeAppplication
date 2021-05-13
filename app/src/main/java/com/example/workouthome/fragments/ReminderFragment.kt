package com.example.workouthome.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentProfileBinding
import com.example.workouthome.databinding.FragmentReminderBinding

class ReminderFragment : Fragment(R.layout.fragment_reminder) {

    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.drinkWaterCard?.setOnClickListener {
            val action = ReminderFragmentDirections.actionAlarmFragmentToDrinkWaterReminder()
            findNavController().navigate(action)
        }

    }
}