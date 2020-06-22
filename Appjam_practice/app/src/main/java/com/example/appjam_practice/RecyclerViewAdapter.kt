package com.example.appjam_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appjam_practice.data.GroupItem


class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.Holder>(){

    var data = listOf<GroupItem>()

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.item_group_list_tv_name)
        val date : TextView = view.findViewById(R.id.item_group_list_tv_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group_list, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = data[position].name
        holder.date.text = data[position].date
    }
}