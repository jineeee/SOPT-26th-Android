package com.example.a2nd_seminar.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter (fm : FragmentManager, val fragmentCount : Int):
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment().newInstance()
            1 -> return BookFragment().newInstance()
            2 -> return MyPageFragment().newInstance()
            else -> null!!
        }
    }


    override fun getCount(): Int = fragmentCount

}