package com.example.workouthome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // click on about me
        _binding?.cardAboutMe?.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToAboutMeFragment()
            findNavController().navigate(action)
        }

        // click on settings
        _binding?.cardSettings?.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToSettingsFragment()
            findNavController().navigate(action)
        }
    }
}