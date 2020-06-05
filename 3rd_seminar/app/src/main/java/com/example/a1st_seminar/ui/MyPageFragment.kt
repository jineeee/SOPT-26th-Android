package com.example.a2nd_seminar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1st_seminar.R

class MyPageFragment : Fragment(){

    fun newInstance(): MyPageFragment {
        val args = Bundle()
        val frag = MyPageFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mypage, container, false)

        return rootView
    }

}