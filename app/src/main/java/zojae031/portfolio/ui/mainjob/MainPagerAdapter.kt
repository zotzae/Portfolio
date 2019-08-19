package zojae031.portfolio.ui.mainjob

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import zojae031.portfolio.ui.FragmentProfile
import zojae031.portfolio.ui.FragmentProject
import zojae031.portfolio.ui.FragmentTec

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragments = listOf(
        FragmentProfile(),
        FragmentProject(),
        FragmentTec()
    )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}