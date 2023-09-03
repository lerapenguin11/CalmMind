package com.example.calmmind.presentation

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calmmind.R
import com.example.calmmind.databinding.FragmentPlaerBinding
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.viewModel.*

class PlayerFragment : Fragment() {
    private var _binding : FragmentPlaerBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel
    private var totalTime: Int = 0
    private lateinit var playerEduViewModel: PlayerEducationViewModel
    private lateinit var playerDesignViewModel: PlayerDesignViewModel
    private lateinit var playerArtsViewModel: PlayerArtsViewModel
    private lateinit var playerAllViewModel: PlayerAllViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlaerBinding.inflate(inflater, container, false)

        playerViewModel = ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)
        playerEduViewModel = ViewModelProvider(requireActivity()).get(PlayerEducationViewModel::class.java)
        playerDesignViewModel = ViewModelProvider(requireActivity()).get(PlayerDesignViewModel::class.java)
        playerArtsViewModel = ViewModelProvider(requireActivity()).get(PlayerArtsViewModel::class.java)
        playerAllViewModel = ViewModelProvider(requireActivity()).get(PlayerAllViewModel::class.java)


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (playerViewModel.player){
            onMusick()
        }
        if (playerEduViewModel.player){
            onMusickEducation()
        }
        if (playerDesignViewModel.player){
            onMusicDesign()
        }
        if (playerArtsViewModel.player){
            onMusicArts()
        }
        if (playerAllViewModel.player){
            onMusicAll()
        }
    }

    private fun onMusicAll() {
        playerAllViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.setText(it.nameMeditation)
            binding.tvNameMeditaton.setText(it.nameMeditation)
            binding.tvNamePodcast.setText(it.namePodcast)
            binding.iconPopular.setImageResource(it.icon)
            playerAllViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerAllViewModel.start()
            totalTime = playerAllViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerAllViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerAllViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerAllViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerAllViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play_arrow) })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerAllViewModel.isPlaying.value == true) {
                    playerAllViewModel.stopPlayback()
                } else {
                    if (!playerAllViewModel.backgroundMusic!!.isPlaying){
                        playerAllViewModel.isPlaying.value = true
                        playerAllViewModel.backgroundMusic!!.start()
                    }
                }
            }

            binding.btBack.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerAllViewModel.isPlaying.value == true){
                    playerAllViewModel.stop()
                    playerAllViewModel.playPreviousSong()
                } else{
                    playerAllViewModel.playPreviousSong()
                }
            }

            binding.btForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerAllViewModel.isPlaying.value == true){
                    playerAllViewModel.backgroundMusic!!.stop()
                    playerAllViewModel.playNextSong()
                } else{
                    playerAllViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerAllViewModel.isPlaying.value == true){
                    playerAllViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerAllViewModel.player = false
                    replaceFragment(AllFragment())
                } else{
                    handler.removeCallbacksAndMessages(null)
                    replaceFragment(AllFragment())
                }

            }

            binding.btMescolare.setOnClickListener {
                // Обработчик нажатия на кнопку перемешивания
                if (playerAllViewModel.isPlaying.value == true){
                    playerAllViewModel.toggleShuffle()
                } else{
                    playerAllViewModel.toggleShuffle()
                }
            }

            binding.btRipetere.setOnClickListener {
                // Обработчик нажатия на кнопку повтора
                if (playerAllViewModel.isPlaying.value == true){
                    playerAllViewModel.toggleRepeat()
                } else{
                    playerAllViewModel.toggleRepeat()
                }
            }
        })
    }

    private fun onMusicArts() {
        playerArtsViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.setText(it.nameMeditation)
            binding.tvNameMeditaton.setText(it.nameMeditation)
            binding.tvNamePodcast.setText(it.namePodcast)
            binding.iconPopular.setImageResource(it.icon)
            playerArtsViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerArtsViewModel.start()
            totalTime = playerArtsViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerArtsViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerArtsViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerArtsViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerArtsViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play_arrow) })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerArtsViewModel.isPlaying.value == true) {
                    playerArtsViewModel.stopPlayback()
                } else {
                    if (!playerArtsViewModel.backgroundMusic!!.isPlaying){
                        playerArtsViewModel.isPlaying.value = true
                        playerArtsViewModel.backgroundMusic!!.start()
                    }
                }
            }

            binding.btBack.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerArtsViewModel.isPlaying.value == true){
                    playerArtsViewModel.stop()
                    playerArtsViewModel.playPreviousSong()
                } else{
                    playerArtsViewModel.playPreviousSong()
                }
            }

            binding.btForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerArtsViewModel.isPlaying.value == true){
                    playerArtsViewModel.backgroundMusic!!.stop()
                    playerArtsViewModel.playNextSong()
                } else{
                    playerArtsViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerArtsViewModel.isPlaying.value == true){
                    playerArtsViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerArtsViewModel.player = false
                    replaceFragment(ArtsFragment())
                } else{
                    handler.removeCallbacksAndMessages(null)
                    replaceFragment(ArtsFragment())
                }

            }

            binding.btMescolare.setOnClickListener {
                // Обработчик нажатия на кнопку перемешивания
                if (playerArtsViewModel.isPlaying.value == true){
                    playerArtsViewModel.toggleShuffle()
                } else{
                    playerArtsViewModel.toggleShuffle()
                }
            }

            binding.btRipetere.setOnClickListener {
                // Обработчик нажатия на кнопку повтора
                if (playerArtsViewModel.isPlaying.value == true){
                    playerArtsViewModel.toggleRepeat()
                } else{
                    playerArtsViewModel.toggleRepeat()
                }
            }
        })
    }

    private fun onMusicDesign() {
        playerDesignViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.setText(it.nameMeditation)
            binding.tvNameMeditaton.setText(it.nameMeditation)
            binding.tvNamePodcast.setText(it.namePodcast)
            binding.iconPopular.setImageResource(it.icon)
            playerDesignViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerDesignViewModel.start()
            totalTime = playerDesignViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerDesignViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerDesignViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerDesignViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerDesignViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play_arrow) })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerDesignViewModel.isPlaying.value == true) {
                    playerDesignViewModel.stopPlayback()
                } else {
                    if (!playerDesignViewModel.backgroundMusic!!.isPlaying){
                        playerDesignViewModel.isPlaying.value = true
                        playerDesignViewModel.backgroundMusic!!.start()
                    }
                }
            }

            binding.btBack.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerDesignViewModel.isPlaying.value == true){
                    playerDesignViewModel.stop()
                    playerDesignViewModel.playPreviousSong()
                } else{
                    playerDesignViewModel.playPreviousSong()
                }
            }

            binding.btForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerDesignViewModel.isPlaying.value == true){
                    playerDesignViewModel.backgroundMusic!!.stop()
                    playerDesignViewModel.playNextSong()
                } else{
                    playerDesignViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerDesignViewModel.isPlaying.value == true){
                    playerDesignViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerDesignViewModel.player = false
                    replaceFragment(DesignFragment())
                } else{
                    handler.removeCallbacksAndMessages(null)
                    replaceFragment(DesignFragment())
                }

            }

            binding.btRipetere.setOnClickListener {
                // Обработчик нажатия на кнопку повтора
                if (playerDesignViewModel.isPlaying.value == true){
                    playerDesignViewModel.toggleRepeat()
                } else{
                    playerDesignViewModel.toggleRepeat()
                }
            }

            binding.btMescolare.setOnClickListener {
                // Обработчик нажатия на кнопку перемешивания
                if (playerDesignViewModel.isPlaying.value == true){
                    playerDesignViewModel.toggleShuffle()
                } else{
                    playerDesignViewModel.toggleShuffle()
                }
            }
        })
    }

    private fun onMusickEducation() {
        playerEduViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.setText(it.nameMeditation)
            binding.tvNameMeditaton.setText(it.nameMeditation)
            binding.tvNamePodcast.setText(it.namePodcast)
            binding.iconPopular.setImageResource(it.icon)
            playerEduViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerEduViewModel.start()
            totalTime = playerEduViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerEduViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerEduViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerEduViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerEduViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play_arrow) })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerEduViewModel.isPlaying.value == true) {
                    playerEduViewModel.stopPlayback()
                } else {
                    if (!playerEduViewModel.backgroundMusic!!.isPlaying){
                        playerEduViewModel.isPlaying.value = true
                        playerEduViewModel.backgroundMusic!!.start()
                    }
                }
            }

            binding.btBack.setOnClickListener {
                // Обработчик нажатия на кнопку предыдущей песни
                if (playerEduViewModel.isPlaying.value == true){
                    playerEduViewModel.stop()
                    playerEduViewModel.playPreviousSong()
                } else{
                    playerEduViewModel.playPreviousSong()
                }
            }

            binding.btForward.setOnClickListener {
                // Обработчик нажатия на кнопку следующей песни
                if (playerEduViewModel.isPlaying.value == true){
                    playerEduViewModel.backgroundMusic!!.stop()
                    playerEduViewModel.playNextSong()
                } else{
                    playerEduViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerEduViewModel.isPlaying.value == true){
                    playerEduViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerEduViewModel.player = false
                    replaceFragment(EducationCategoryFragment())
                } else{
                    handler.removeCallbacksAndMessages(null)
                    replaceFragment(EducationCategoryFragment())
                }

            }

            binding.btMescolare.setOnClickListener {
                // Обработчик нажатия на кнопку перемешивания
                if (playerEduViewModel.isPlaying.value == true){
                    playerEduViewModel.toggleShuffle()
                } else{
                    playerEduViewModel.toggleShuffle()
                }
            }

            binding.btRipetere.setOnClickListener {
                // Обработчик нажатия на кнопку повтора
                if (playerEduViewModel.isPlaying.value == true){
                    playerEduViewModel.toggleRepeat()
                } else{
                    playerEduViewModel.toggleRepeat()
                }
            }
        })
    }

    private fun onMusick() {
        playerViewModel.currentSong.observe(viewLifecycleOwner, Observer {
            binding.tvNameMeditation.setText(it.nameMeditation)
            binding.tvNameMeditaton.setText(it.nameMeditation)
            binding.tvNamePodcast.setText(it.namePodcast)
            binding.iconPopular.setImageResource(it.icon)
            playerViewModel.initBackgroundMusicSetting(requireContext(), it)
            playerViewModel.start()
            totalTime = playerViewModel.backgroundMusic!!.duration
            binding.seekBar.max = totalTime

            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        playerViewModel.backgroundMusic!!.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val currentTime = playerViewModel.backgroundMusic!!.currentPosition
                    binding.seekBar.progress = currentTime
                    binding.tvTimeStart.text = createTimeLabel(currentTime)
                    handler.postDelayed(this, 1000)

                    if (currentTime == totalTime){
                        playerViewModel.playNextSong()
                    }
                }
            }, 0)

            binding.tvTimeEnd.text = createTimeLabel(totalTime)

            playerViewModel.isPlaying.observe(viewLifecycleOwner, Observer { isPlaying ->
                binding.playButton.setImageResource(if (isPlaying) R.drawable.ic_stop else R.drawable.ic_play_arrow) })

            binding.btSongStop.setOnClickListener {
                // Обработчик нажатия на кнопку воспроизведения/паузы
                if (playerViewModel.isPlaying.value == true) {
                    playerViewModel.stopPlayback()
                } else {
                    if (!playerViewModel.backgroundMusic!!.isPlaying){
                        playerViewModel.isPlaying.value = true
                        playerViewModel.backgroundMusic!!.start()
                    }
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
                    playerViewModel.backgroundMusic!!.stop()
                    playerViewModel.playNextSong()
                } else{
                    playerViewModel.playNextSong()
                }
            }

            binding.icArrow.setOnClickListener{
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.backgroundMusic!!.stop()
                    handler.removeCallbacksAndMessages(null)
                    playerViewModel.player = false
                    replaceFragment(HomeFragment())
                } else {
                    handler.removeCallbacksAndMessages(null)
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

            binding.btRipetere.setOnClickListener {
                // Обработчик нажатия на кнопку повтора
                if (playerViewModel.isPlaying.value == true){
                    playerViewModel.toggleRepeat()
                } else{
                    playerViewModel.toggleRepeat()
                }
            }
        })
    }

    private fun createTimeLabel(time: Int): String {
        val minutes = time / 1000 / 60
        val seconds = time / 1000 % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        playerViewModel.backgroundMusic!!.release()
        playerEduViewModel.backgroundMusic!!.release()
    }
}