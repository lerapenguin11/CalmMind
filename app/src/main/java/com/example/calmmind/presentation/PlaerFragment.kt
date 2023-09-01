package com.example.calmmind.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.calmmind.R
import com.example.calmmind.databinding.FragmentHomeBinding
import com.example.calmmind.databinding.FragmentPlaerBinding
import com.example.calmmind.viewModel.HomeViewModel

class PlaerFragment : Fragment() {
    private var _binding : FragmentPlaerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlaerBinding.inflate(inflater, container, false)

        binding.tvNameMeditation.text = arguments?.getString("nameMed")
        binding.tvNameMeditaton.text = arguments?.getString("nameMed")
        binding.tvNamePodcast.text = arguments?.getString("namePodcast")
        binding.iconPopular.setImageResource(arguments?.getInt("icon")!!)


        return binding.root
    }
}