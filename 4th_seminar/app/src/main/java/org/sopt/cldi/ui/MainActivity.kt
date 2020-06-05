package org.sopt.cldi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.sopt.cldi.DateParser
import org.sopt.cldi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MainPagerAdapter(supportFragmentManager)
        main_viewPager.adapter = fragmentAdapter

        tabbar.setupWithViewPager(main_viewPager)

        Log.e("28일", DateParser.calculateDiffDate("2020-05-28 12:00:00"))
        Log.e("30일 12시", DateParser.calculateDiffDate("2020-05-30 12:00:00"))
        Log.e("30일 1시", DateParser.calculateDiffDate("2020-05-30 13:00:00"))
    }

}
