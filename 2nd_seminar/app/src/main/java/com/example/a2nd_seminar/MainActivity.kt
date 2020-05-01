package com.example.a2nd_seminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container.adapter = MainPagerAdapter(supportFragmentManager, 3)
        container.offscreenPageLimit = 2
        container.setCurrentItem(1)
        bottomNaviBar.menu.getItem(1).setChecked(true)

        bottomNavi()
        changeItem()
    }

    fun bottomNavi(){
        bottomNaviBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_one -> {
                    container.setCurrentItem(0)
                }
                R.id.action_two -> {
                    container.setCurrentItem(1)
                }
                R.id.action_three -> {
                    container.setCurrentItem(2)
                }
            }
            true
        }
    }

    private fun changeItem(){

        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNaviBar.menu.getItem(position).isChecked = true
            }
        })
    }
}
