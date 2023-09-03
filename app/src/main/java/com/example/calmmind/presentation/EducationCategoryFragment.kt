package com.example.calmmind.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calmmind.R
import com.example.calmmind.business.model.MeditationModel
import com.example.calmmind.databinding.FragmentEducationCategoryBinding
import com.example.calmmind.databinding.FragmentHomeBinding
import com.example.calmmind.presentation.adapter.EducationAdapter
import com.example.calmmind.presentation.adapter.PopularAdapter
import com.example.calmmind.presentation.listener.PopularListener
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.viewModel.PlayerEducationViewModel
import com.example.calmmind.viewModel.PlayerViewModel

class EducationCategoryFragment : Fragment(), PopularListener {
    private var _binding : FragmentEducationCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerEducationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEducationCategoryBinding.inflate(inflater, container, false)
        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerEducationViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        onClick()
        setEducation()
    }

    private fun setEducation() {
        val adapter = EducationAdapter(this, playerViewModel.songs.value!!)
        binding.rvEducation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvEducation.adapter = adapter

        playerViewModel.songs.observe(viewLifecycleOwner, Observer { songs ->
            adapter.setItem(songs)
        })
    }

    private fun onClick() {
        binding.icArrow.setOnClickListener {
            replaceFragment(HomeFragment())
        }
    }

    override fun popularList(popular: MeditationModel) {
        playerViewModel.playSong(song = popular)
        playerViewModel.player = true
        replaceFragment(PlayerFragment())
    }
}