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

class ThreeFragment : Fragment(){

    lateinit var adapter: RecyclerViewAdapter
    lateinit var fragThreeRv : RecyclerView

    var dummy = listOf(
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템1"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템2"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템3"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템4"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템5"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템6"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템7"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            txt = "아이템8"
        )
    )

    fun newInstance(): ThreeFragment {
        val args = Bundle()
        val frag = ThreeFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_three, container, false)
        fragThreeRv = rootView.findViewById(R.id.frag_three_rv) as RecyclerView
        initRv()

        return rootView
    }

    fun initRv(){
        adapter = RecyclerViewAdapter(requireContext())
        fragThreeRv.adapter = adapter
        fragThreeRv.layoutManager = GridLayoutManager(requireContext(), 2)
        fragThreeRv.addItemDecoration(ItemDecorator(10,10))
        adapter.data = dummy
        adapter.notifyDataSetChanged()
    }
}