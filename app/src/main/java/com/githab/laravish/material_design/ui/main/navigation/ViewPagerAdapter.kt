package com.githab.laravish.material_design.ui.main.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.githab.laravish.material_design.EARTH
import com.githab.laravish.material_design.MARS
import com.githab.laravish.material_design.SYSTEM

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments =
        arrayOf(FirstPictureFragment(), SecondPictureFragment(), ThirdPictureFragment())

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> EARTH
            1 -> MARS
            2 -> SYSTEM
            else -> {
                EARTH
            }
        }
    }
}