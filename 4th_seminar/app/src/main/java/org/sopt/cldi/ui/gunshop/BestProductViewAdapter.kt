package org.sopt.cldi.ui.gunshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cldi.R
import org.sopt.cldi.data.BestProductItem


class BestProductViewAdapter(val context: Context): RecyclerView.Adapter<BestProductViewAdapter.Holder>(){

    var data = listOf<BestProductItem>()

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val thumb :ImageView = view.findViewById(R.id.item_best_product_iv_thumbnail)
        val title : TextView = view.findViewById(R.id.item_best_product_tv_title)
        val price : TextView = view.findViewById(R.id.item_best_product_tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_product, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.thumb.setImageResource(data[position].thumb)
        holder.title.text = data[position].title
        holder.price.text = data[position].price
    }
}