package com.example.calmmind.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.calmmind.R
import com.example.calmmind.databinding.ActivityMainBinding
import com.example.calmmind.utilits.APP_ACTIVITY
import com.example.calmmind.utilits.replaceFragment
import com.example.calmmind.utilits.setStatusBarGradiant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setStatusBarGradiant(this)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.all -> replaceFragment(AllFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE
    }
}