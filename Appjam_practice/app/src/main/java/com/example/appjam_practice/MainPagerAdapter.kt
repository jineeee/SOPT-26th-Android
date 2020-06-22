package com.example.appjam_practice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter (fm : FragmentManager, val fragmentCount : Int):
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment().newInstance()
            1 -> return AddFragment().newInstance()
            2 -> return ListFragment().newInstance()
            3 -> return UserFragment().newInstance()
            else -> null!!
        }
    }


    override fun getCount(): Int = fragmentCount

}