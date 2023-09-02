package com.example.calmmind.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calmmind.R
import com.example.calmmind.databinding.FragmentPlaerBinding
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.viewModel.PlayerViewModel

class PlayerFragment : Fragment() {
    private var _binding : FragmentPlaerBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlaerBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        onMusick()
    }

    private fun onMusick() {

        playerViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.text = it.nameMeditation
            binding.tvNameMeditaton.text = it.nameMeditation
            binding.tvNamePodcast.text = it.namePodcast
            binding.iconPopular.setImageResource(it.icon)
            playerViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerViewModel.start()

            playerViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play)
            })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerViewModel.isPlaying.value == true) {
                    playerViewModel.stopPlayback()
                    //playerViewModel.stop()
                } else {
                    playerViewModel.playSong(playerViewModel.currentSong.value!!)
                }
            }

            binding.btBack.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.stop()
                    playerViewModel.playPreviousSong()
                } else{
                    playerViewModel.playPreviousSong()
                }
            }

            binding.btForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.stop()
                    playerViewModel.playNextSong()
                } else{
                    playerViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.stop()
                    replaceFragment(HomeFragment())
                } else{
                    replaceFragment(HomeFragment())
                }
            }

            binding.btMescolare.setOnClickListener {
                // Обработчик нажатия на кнопку перемешивания
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.toggleShuffle()
                } else{
                    playerViewModel.toggleShuffle()
                }
            }
        })
    }
}