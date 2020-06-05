package org.sopt.cldi.ui.gomshintalk

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.provider.Settings.System.DATE_FORMAT
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import org.sopt.cldi.R
import org.sopt.cldi.data.GomshinTalkData
import java.text.SimpleDateFormat
import java.util.*

class GomshinTalkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_list_num = itemView.findViewById<TextView>(R.id.tv_list_num)
    val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
    val img_content_image = itemView.findViewById<ImageView>(R.id.img_content_image)
    val tv_user_level = itemView.findViewById<TextView>(R.id.tv_user_level)
    val tv_user_nick = itemView.findViewById<TextView>(R.id.tv_user_nick)
    val tv_like_count = itemView.findViewById<TextView>(R.id.tv_like_count)
    val tv_comment_count = itemView.findViewById<TextView>(R.id.tv_comment_count)
    val tv_category = itemView.findViewById<TextView>(R.id.tv_category)
    val tv_time = itemView.findViewById<TextView>(R.id.tv_time)
    val ic_military_rank = itemView.findViewById<ImageView>(R.id.ic_military_rank)

    val category_minitalk = itemView.context.getDrawable(R.drawable.ic_minitalk)
    val category_counselor = itemView.context.getDrawable(R.drawable.ic_counselor)
    val category_grouppurchase = itemView.context.getDrawable(R.drawable.ic_grouppurchase)
    val category_gallery = itemView.context.getDrawable(R.drawable.ic_gallery)
    val category_sendingletter = itemView.context.getDrawable(R.drawable.ic_sendingletter)

    fun bind(customData: GomshinTalkData) {
        tv_list_num.text = customData.num.toString()
        tv_title.text = customData.title
        loadImage(customData.image)
        tv_user_level.text = customData.level
        tv_user_nick.text = customData.nick
        tv_like_count.text = customData.like.toString()
        tv_comment_count.text = customData.comment.toString()
        tv_category.text = customData.category
        setCategory(customData.category)
        tv_time.text = customData.time
        setMilitaryRank(customData.rank)
    }

    private fun loadImage(image:String?) {
        if (image == null) {
            img_content_image.visibility = View.INVISIBLE
        } else {
            Glide.with(itemView)
                .load(image)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(img_content_image)
            imageRadius()
        }
    }

    private fun imageRadius() {
        //ImageView 둥근 모서리 처리
        val drawable: GradientDrawable = itemView.context.getDrawable(R.drawable.background_rounding) as GradientDrawable
        img_content_image?.background = drawable
        img_content_image?.clipToOutline = true
    }


    private fun setCategory(category:String) {
        when (category) {
            "연애상담"-> {
                tv_category.background = category_counselor
                tv_category.setTextColor(Color.rgb(0,185,177))
            }
            "곰신미니톡" -> {
                tv_category.background = category_minitalk
                tv_category.setTextColor(Color.rgb(128,206,188))
            }
            "공동구매" -> {
                tv_category.background = category_grouppurchase
                tv_category.setTextColor(Color.rgb(255,189,209))
            }
            "곰신사진첩" -> {
                tv_category.background = category_gallery
                tv_category.setTextColor(Color.rgb(255,198,110))
            }
            "편지보내기" -> {
                tv_category.background = category_sendingletter
                tv_category.setTextColor(Color.rgb(195,165,150))
            }
       }
    }

    private fun setMilitaryRank(rank:String) {
        when (rank) {
            "육군 이등병" -> ic_military_rank.setImageResource(R.drawable.ic_army1)
            "육군 일병" -> ic_military_rank.setImageResource(R.drawable.ic_army2)
            "육군 상병" -> ic_military_rank.setImageResource(R.drawable.ic_army3)
            "육군 병장" -> ic_military_rank.setImageResource(R.drawable.ic_army4)

            "해군 이등병" -> ic_military_rank.setImageResource(R.drawable.ic_navy1)
            "해군 일병" -> ic_military_rank.setImageResource(R.drawable.ic_navy2)
            "해군 상병" -> ic_military_rank.setImageResource(R.drawable.ic_navy3)
            "해군 병장" -> ic_military_rank.setImageResource(R.drawable.ic_navy4)

            "공군 이등병" -> ic_military_rank.setImageResource(R.drawable.ic_airforce1)
            "공군 일병" -> ic_military_rank.setImageResource(R.drawable.ic_airforce2)
            "공군 상병" -> ic_military_rank.setImageResource(R.drawable.ic_airforce3)
            "공군 병장" -> ic_military_rank.setImageResource(R.drawable.ic_airforce4)

            "해병대 이등병" -> ic_military_rank.setImageResource(R.drawable.ic_haebyungdae1)
            "해병대 일병" -> ic_military_rank.setImageResource(R.drawable.ic_haebyungdae2)
            "해병대 상병" -> ic_military_rank.setImageResource(R.drawable.ic_haebyungdae3)
            "해병대 병장" -> ic_military_rank.setImageResource(R.drawable.ic_haebyungdae4)

            "의경 이경" -> ic_military_rank.setImageResource(R.drawable.ic_police1)
            "의경 일경" -> ic_military_rank.setImageResource(R.drawable.ic_police2)
            "의경 상경" -> ic_military_rank.setImageResource(R.drawable.ic_police3)
            "의경 수경" -> ic_military_rank.setImageResource(R.drawable.ic_police4)
        }
    }
}