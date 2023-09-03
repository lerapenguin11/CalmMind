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
import com.example.calmmind.databinding.FragmentArtsBinding
import com.example.calmmind.databinding.FragmentDesignBinding
import com.example.calmmind.presentation.adapter.ArtsAdapter
import com.example.calmmind.presentation.adapter.DesignAdapter
import com.example.calmmind.presentation.listener.PopularListener
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.viewModel.PlayerArtsViewModel
import com.example.calmmind.viewModel.PlayerDesignViewModel

class ArtsFragment : Fragment(), PopularListener {
    private var _binding : FragmentArtsBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerArtsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentArtsBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerArtsViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        onClick()
        setArts()
    }

    private fun setArts() {
        val adapter = ArtsAdapter(this, playerViewModel.songs.value!!)
        binding.rvDesign.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvDesign.adapter = adapter

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