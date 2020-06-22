package com.example.appjam_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appjam_practice.data.GroupItem

class ListFragment : Fragment() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var fragListRv : RecyclerView

    var dummy = listOf(
        GroupItem(
            name = "SOPT 26기 안드로이드 세미나",
            date = "2020/04/25"
        ),
        GroupItem(
            name = "안드로이드 스터디",
            date = "2020/05/26"
        ),
        GroupItem(
            name = "리모트워크 세미나",
            date = "2020/05/27"
        ),
        GroupItem(
            name = "미디어팀 모임",
            date = "2020/06/25"
        ),
        GroupItem(
            name = "안드로이드 스터디",
            date = "2020/06/26"
        ),
        GroupItem(
            name = "SOPT 26기 팀빌딩",
            date = "2020/06/27"
        ),
        GroupItem(
            name = "큐링",
            date = "2020/04/25"
        ),
        GroupItem(
            name = "저",
            date = "2020/05/26"
        ),
        GroupItem(
            name = "뽑아주세요",
            date = "2020/05/27"
        )
    )

    fun newInstance(): ListFragment {
        val args = Bundle()
        val frag = ListFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        fragListRv = view.findViewById(R.id.frag_list_rv) as RecyclerView
        initRv()

        return view
    }

    fun initRv(){
        adapter = RecyclerViewAdapter(requireContext())
        fragListRv.adapter = adapter
        fragListRv.layoutManager = LinearLayoutManager(requireContext())
        adapter.data = dummy
        adapter.notifyDataSetChanged()
    }
}
