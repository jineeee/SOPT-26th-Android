package org.sopt.cldi.ui.gunshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.sopt.cldi.R
import org.sopt.cldi.data.BestGunShopData

class BestGunShopRecyclerView : RecyclerView.Adapter<BestGunShopRecyclerView.ViewHolder>() {

    private val dummy : List<BestGunShopData> = listOf(
        BestGunShopData(
            1,
            R.drawable.gunshop_img_bestshoplogo_1,
            "코코곰신",
            "군입대 준비물, 군인용품 직배송"
        ),
        BestGunShopData(
            2,
            R.drawable.gunshop_img_bestshoplogo_2,
            "과자선물",
            "12시까지 주문하면 내일도착"
        ),
        BestGunShopData(
            3,
            R.drawable.gunshop_img_bestshoplogo_3,
            "그라펜",
            "남성전용 화장품 몰"
        ),
        BestGunShopData(
            4,
            R.drawable.gunshop_img_bestshoplogo_4,
            "곰신몰",
            "군인과 곰신을 위한 공동구매"
        ),
        BestGunShopData(
            5,
            R.drawable.gunshop_img_bestshoplogo_5,
            "나이키 남성",
            "컬렉션, 스포츠, 아웃웨어, 운동화"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_best_gunshop, parent, false))

    override fun getItemCount(): Int = dummy.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dummy[position])
    }

    /** 뷰홀더 */
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val txtRankNum : TextView = view.findViewById(R.id.txtRankNum)
        private val ivShopLogo : ImageView = view.findViewById(R.id.ivShopLogo)
        private val txtShopName : TextView = view.findViewById(R.id.txtShopName)
        private val txtDescription : TextView = view.findViewById(R.id.txtDescription)

        fun onBind(data: BestGunShopData){
            txtRankNum.text = data.rank.toString()
            ivShopLogo.setImageResource(data.image)
            txtShopName.text = data.shopName
            txtDescription.text = data.description
        }

    }

}