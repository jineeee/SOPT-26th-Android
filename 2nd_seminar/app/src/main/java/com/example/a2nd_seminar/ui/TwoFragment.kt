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

class TwoFragment : Fragment(){

    lateinit var adapter: RecyclerViewAdapter
    lateinit var fragTwoRv : RecyclerView

    var dummy = listOf(
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템1"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템2"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템3"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템4"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템5"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템6"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템7"
        ),
        RvItem(
            img = "https://i.pinimg.com/564x/3c/a2/89/3ca289cf9b103865600f24c7b370a842.jpg",
            txt = "아이템8"
        )
    )

    fun newInstance(): TwoFragment {
        val args = Bundle()
        val frag = TwoFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_two, container, false)
        fragTwoRv = rootView.findViewById(R.id.frag_two_rv) as RecyclerView
        initRv()

        return rootView
    }

    fun initRv(){
        adapter = RecyclerViewAdapter(requireContext())
        fragTwoRv.adapter = adapter
        fragTwoRv.layoutManager = GridLayoutManager(requireContext(), 2)
        fragTwoRv.addItemDecoration(ItemDecorator(10,10))
        adapter.data = dummy
        adapter.notifyDataSetChanged()
    }
}