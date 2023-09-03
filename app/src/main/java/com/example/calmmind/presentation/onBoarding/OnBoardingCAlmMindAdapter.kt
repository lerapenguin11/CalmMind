package com.example.calmmind.presentation.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingCAlmMindAdapter (a : ArrayList<Fragment>, m : FragmentManager, l : Lifecycle)
    : FragmentStateAdapter(m, l) {

    private val fragmentListOnBoarding = a

    override fun getItemCount(): Int = fragmentListOnBoarding.size

    override fun createFragment(position: Int): Fragment = fragmentListOnBoarding[position]
}