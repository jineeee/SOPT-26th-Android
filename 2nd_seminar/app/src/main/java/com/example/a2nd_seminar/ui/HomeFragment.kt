package com.example.a2nd_seminar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2nd_seminar.R
import com.example.a2nd_seminar.data.RvItem

class HomeFragment :Fragment(){

    lateinit var adapter: RecyclerViewAdapter
    lateinit var fragHomeRv : RecyclerView

    var dummy = listOf(
        RvItem(
            profile = "https://i.pinimg.com/564x/88/22/33/882233835380f5979008699b406218cc.jpg",
            id = "imdecemberlover",
            content = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg"
        ),
        RvItem(
            profile = "https://i.pinimg.com/564x/8d/b9/b6/8db9b6d171453eaf29d97160610bf8d3.jpg",
            id = "hungryman",
            content = "https://i.pinimg.com/564x/40/b1/c9/40b1c95d3355bfc8311d4fce7a10a859.jpg"
        ),
        RvItem(
            profile = "https://i.pinimg.com/236x/0b/01/4f/0b014fb6ac5dc338457dd8f9a0abf1e5.jpg",
            id = "rainrainrain",
            content = "https://i.pinimg.com/564x/ae/33/65/ae3365783b045d606627132f09e426c5.jpg"
        ),
        RvItem(
            profile = "https://i.pinimg.com/564x/8a/b0/83/8ab083690720823aaa17763c7d1d8573.jpg",
            id = "imdecemberlover",
            content = "https://i.pinimg.com/236x/68/25/a0/6825a0a4c7a5ed2512003b1a4c12a70a.jpg"
        )
    )

    fun newInstance(): HomeFragment {
        val args = Bundle()
        val frag = HomeFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        fragHomeRv = rootView.findViewById(R.id.frag_home_rv) as RecyclerView
        initRv()

        return rootView
    }

    fun initRv(){
        adapter = RecyclerViewAdapter(requireContext())
        fragHomeRv.adapter = adapter
        fragHomeRv.layoutManager = LinearLayoutManager(requireContext())
        fragHomeRv.addItemDecoration(ItemDecorator(5))
        adapter.data = dummy
        adapter.notifyDataSetChanged()
    }
}