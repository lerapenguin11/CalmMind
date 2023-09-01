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
import com.example.calmmind.databinding.FragmentHomeBinding
import com.example.calmmind.presentation.adapter.CategoryAdapter
import com.example.calmmind.presentation.adapter.PopularAdapter
import com.example.calmmind.presentation.listener.PopularListener
import com.example.calmmind.viewModel.HomeViewModel

class HomeFragment : Fragment(), PopularListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel : HomeViewModel
    private val categoryAdapter = CategoryAdapter()
    private val popularAdapter = PopularAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setCategory()
        setPopular()
    }

    private fun setPopular() {
        binding.rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvPopular.adapter = popularAdapter

        homeViewModel.getPopular().observe(viewLifecycleOwner, Observer {
            popularAdapter.setItem(it)
        })
    }

    private fun setCategory() {
        binding.rvCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = categoryAdapter

        homeViewModel.getCategory().observe(viewLifecycleOwner, Observer {
            categoryAdapter.setItem(it)
        })
    }

    override fun popularList(popular: MeditationModel) {
        val bundle = Bundle()
        bundle.putString("nameMed", popular.nameMeditation)
        bundle.putString("namePodcast", popular.namePodcast)
        bundle.putInt("icon", popular.icon)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val fragment = PlaerFragment()
        fragment.arguments = bundle
        transaction?.replace(R.id.main_layout, fragment)
        transaction?.commit()
    }
}