package com.example.a2nd_seminar.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a2nd_seminar.R
import com.example.a2nd_seminar.data.RvItem


class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.Holder>(){

    var data = listOf<RvItem>()

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val img : ImageView = view.findViewById(R.id.item_frag_iv_img)
        val text : TextView = view.findViewById(R.id.item_frag_tv_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_frag_two, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(context)
            .load(data[position].img)
            .override(200,200)
            .centerCrop()
            .into(holder.img)

        holder.text.text = data[position].txt
    }
}