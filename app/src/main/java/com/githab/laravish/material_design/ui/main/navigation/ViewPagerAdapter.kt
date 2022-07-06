package com.githab.laravish.material_design.ui.main.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments =
        arrayOf(FirstPictureFragment(), SecondPictureFragment(), ThirdPictureFragment())

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]
}