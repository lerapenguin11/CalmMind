package com.example.calmmind.presentation.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.calmmind.R

class SecondFragmentOB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second_o_b, container, false)

        val d = view.findViewById<TextView>(R.id.textView3)
        return view
    }

    override fun onResume() {
        super.onResume()
    }
}