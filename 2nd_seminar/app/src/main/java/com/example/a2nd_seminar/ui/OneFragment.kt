package com.example.a2nd_seminar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2nd_seminar.R
import com.example.a2nd_seminar.data.RvItem

class OneFragment :Fragment(){

    lateinit var adapter: RecyclerViewAdapter
    lateinit var fragOneRv : RecyclerView

    var dummy = listOf(
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템1"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템2"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템3"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템4"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템5"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템6"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템7"
        ),
        RvItem(
            img = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg",
            txt = "아이템8"
        )
    )

    fun newInstance(): OneFragment {
        val args = Bundle()
        val frag = OneFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false)
        fragOneRv = rootView.findViewById(R.id.frag_two_rv) as RecyclerView
        initRv()

        return rootView
    }

    fun initRv(){
        adapter = RecyclerViewAdapter(requireContext())
        fragOneRv.adapter = adapter
        fragOneRv.layoutManager = GridLayoutManager(requireContext(), 2)
        fragOneRv.addItemDecoration(ItemDecorator(10,10))
        adapter.data = dummy
        adapter.notifyDataSetChanged()
    }
}