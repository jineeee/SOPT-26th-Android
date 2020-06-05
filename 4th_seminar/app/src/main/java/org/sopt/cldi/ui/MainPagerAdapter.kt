package org.sopt.cldi.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.sopt.cldi.ui.gomshintalk.GomshinTalkFragment
import org.sopt.cldi.ui.gunshop.GunShopFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BlankFragment()
            1 -> BlankFragment()
            2 -> GomshinTalkFragment()
            3 -> GunShopFragment()
            else -> BlankFragment()
        }
    }
    override fun getCount() = 5

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "계산기"
            1 -> "편지"
            2 -> "곰신톡"
            3 -> "군샵"
            else -> {
                return "별존"
            }
        }
    }
}