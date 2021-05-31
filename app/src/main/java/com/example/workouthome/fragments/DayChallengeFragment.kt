package com.example.workouthome.fragments

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentDayChallengeBinding
import com.example.workouthome.utils.Constants
import com.example.workouthome.viewmodel.ChallengeViewModel
import kotlinx.android.synthetic.main.fragment_day_challenge.*

class DayChallengeFragment : Fragment(R.layout.fragment_day_challenge) {

    private var _binding: FragmentDayChallengeBinding? = null
    private val binding get() = _binding!!
    private var mediaController: MediaController? = null
    private var dayNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            dayNumber = this.getInt(Constants.CHALLENGE_DAY_NUMBER)
            Log.d("DayChallengeFragment", "onCreate dayNumber $dayNumber")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayChallengeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val challengeViewModel = activity?.let { ChallengeViewModel() }
        super.onViewCreated(view, savedInstanceState)
        val path = challengeViewModel?.setChallengeVideo(dayNumber)
        val description = challengeViewModel?.setChallengeDescription(dayNumber)
        setVideo(path!!)
        _binding?.exercicesDescription?.text = description
    }

    private fun setVideo(path: String) {
        val uri = Uri.parse(path)

        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.setOnCompletionListener {
            Toast.makeText(requireActivity(), R.string.end_watching, Toast.LENGTH_LONG).show()
        }

        videoView.setOnErrorListener { _, _, _ ->
            Toast.makeText(requireActivity(), R.string.error_occurred, Toast.LENGTH_LONG).show()
            false
        }

        videoView.setOnPreparedListener { mp ->
            videoView.start()
            mp.setOnVideoSizeChangedListener { _, _, _ ->
                mediaController = MediaController(activity)
                videoView.setMediaController(mediaController)
                mediaController!!.setAnchorView(videoView)
            }
        }
    }
}