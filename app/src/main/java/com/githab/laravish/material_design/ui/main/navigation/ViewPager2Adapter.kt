package com.githab.laravish.material_design.ui.main.navigation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fa: Fragment) : FragmentStateAdapter(fa) {

    private val fragments = arrayOf(FirstPictureFragment(), SecondPictureFragment(), ThirdPictureFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
       return fragments[position]
    }

}