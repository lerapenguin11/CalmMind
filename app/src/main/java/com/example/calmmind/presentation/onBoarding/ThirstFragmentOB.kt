package com.example.calmmind.presentation.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calmmind.R

class ThirstFragmentOB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewThirst = inflater.inflate(R.layout.fragment_thirst_o_b, container, false)
        return viewThirst
    }

    override fun onResume() {
        super.onResume()
    }
}