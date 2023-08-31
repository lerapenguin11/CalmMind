package com.example.calmmind.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calmmind.R
import com.example.calmmind.utilits.APP_ACTIVITY
import com.example.calmmind.utilits.setStatusBarGradiant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this
        setStatusBarGradiant(this)
    }
}