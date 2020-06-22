package com.example.appjam_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container.adapter =
            MainPagerAdapter(
                supportFragmentManager,
                4
            )
        container.offscreenPageLimit = 3
        container.currentItem = 0
        bottomNaviBar.menu.getItem(0).isChecked = true

        bottomNavi()
        changeItem()

    }

    private fun bottomNavi(){
        bottomNaviBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> container.currentItem = 0
                R.id.action_add -> container.currentItem = 1
                R.id.action_list -> container.currentItem = 2
                R.id.action_user -> container.currentItem = 3
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
