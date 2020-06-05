package org.sopt.cldi.ui.gunshop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_gun_shop.*
import org.sopt.cldi.R
import org.sopt.cldi.data.BestProductItem

class GunShopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_gun_shop, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClearFocus()
        initPopularTags()
        initBestProductRecyclerView()
        initBestGunShopRecyclerView()
    }


    private fun initClearFocus() {
        edtSearch.clearFocus()
    }

    private fun initPopularTags() {
        listOf("가나다", "라마바", "사아자", "일이삼")
            .asSequence()
            .map { "#$it" }
            .toList()
            .forEach {
                val tag = layoutInflater.inflate(R.layout.item_popular_tag, tagContainer, false) as TextView
                tag.text = it
                tagContainer.addView(tag)
            }
    }

    private fun initBestGunShopRecyclerView() {
        rvBestGunShop.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BestGunShopRecyclerView().apply { notifyDataSetChanged() }
        }
    }


    private fun initBestProductRecyclerView(){
        val dummy = listOf(
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_1,
                title = "나이키 에어포스",
                price = "180,000"
            ),
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_2,
                title = "나이키 데이브레이크",
                price = "120,000"
            ),
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_3,
                title = "이니스프리 로션",
                price = "55,000"
            ),
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_4,
                title = "필립스 면도기",
                price = "140,000"
            ),
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_5,
                title = "구급상자",
                price = "43,000"
            ),
            BestProductItem(
                thumb = R.drawable.gunshop_img_best_6,
                title = "이니스프리 로션",
                price = "48,000"
            )
        )

        val bestProductRecyclerViewAdapter = BestProductViewAdapter(requireContext())
        frag_gun_shop_rv_list.adapter = bestProductRecyclerViewAdapter
        frag_gun_shop_rv_list.layoutManager = GridLayoutManager(requireContext(),3)
        bestProductRecyclerViewAdapter.data = dummy
        bestProductRecyclerViewAdapter.notifyDataSetChanged()
    }

}
