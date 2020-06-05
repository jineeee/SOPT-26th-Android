package com.example.a1st_seminar.ui.insta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.a1st_seminar.R
import com.example.a2nd_seminar.ui.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container.adapter =
            MainPagerAdapter(
                supportFragmentManager,
                3
            )
        container.offscreenPageLimit = 2
        container.currentItem = 0
        bottomNaviBar.menu.getItem(0).isChecked = true

        bottomNavi()
        changeItem()
    }

    fun bottomNavi(){
        bottomNaviBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> container.currentItem = 0
                R.id.action_book -> container.currentItem = 1
                R.id.action_myPage -> container.currentItem = 2
            }
            true
        }
    }

    private fun changeItem(){

        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                bottomNaviBar.menu.getItem(position).isChecked = true
            }
        })
    }
}
