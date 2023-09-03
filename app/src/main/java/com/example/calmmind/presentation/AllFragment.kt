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
import com.example.calmmind.databinding.FragmentAllBinding
import com.example.calmmind.databinding.FragmentPlaerBinding
import com.example.calmmind.presentation.adapter.AllMeditationAdapter
import com.example.calmmind.presentation.adapter.ArtsAdapter
import com.example.calmmind.presentation.listener.PopularListener
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.viewModel.PlayerAllViewModel
import com.example.calmmind.viewModel.PlayerArtsViewModel
import com.example.calmmind.viewModel.PlayerViewModel

class AllFragment : Fragment(), PopularListener {
    private var _binding : FragmentAllBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerAllViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerAllViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setAllMeditation()
    }

    private fun setAllMeditation() {
        val adapter = AllMeditationAdapter(this, playerViewModel.songs.value!!)
        binding.rvDesign.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvDesign.adapter = adapter

        playerViewModel.songs.observe(viewLifecycleOwner, Observer { songs ->
            adapter.setItem(songs)
        })
    }

    override fun popularList(popular: MeditationModel) {
        playerViewModel.playSong(song = popular)
        playerViewModel.player = true
        replaceFragment(PlayerFragment())
    }
}