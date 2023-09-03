package com.example.calmmind.presentation.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.calmmind.R
import com.example.calmmind.presentation.MainActivity
import com.example.calmmind.utilits.setStatusBarGradiant
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardiangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boardiang)

        setContentView(R.layout.activity_on_boardiang)
        setViewPager()
        setStatusBarGradiant(this)
    }

    private fun setViewPager() {
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(ThirstFragmentOB())
        fragmentList.add(SecondFragmentOB())
        val adapterViewPager = OnBoardingCAlmMindAdapter(
            fragmentList,
            this.supportFragmentManager,
            lifecycle
        )
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapterViewPager
        val indicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        indicator.attachTo(viewPager)
        val finish = findViewById<ImageView>(R.id.finish)
        finish.setOnClickListener { v: View? ->
            val intent = Intent(
                this@OnBoardiangActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}