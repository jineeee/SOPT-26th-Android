package com.example.a2nd_seminar.ui

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a1st_seminar.R
import com.example.a1st_seminar.data.model.RvItem
import de.hdodenhof.circleimageview.CircleImageView


class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.Holder>(){

    var data = listOf<RvItem>()

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImg :ImageView = view.findViewById(R.id.item_insta_profile_img)
        val id : TextView = view.findViewById(R.id.item_insta_profile_id)
        val contentImg : ImageView = view.findViewById(R.id.item_insta_content_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instagram, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(context)
            .load(data[position].profile)
            .centerCrop()
            .into(holder.profileImg)

        holder.id.text = data[position].id

        Glide.with(context)
            .load(data[position].content)
            .centerCrop()
            .into(holder.contentImg)
    }
}