package com.githab.laravish.material_design.ui.main.layouts

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2FavoriteAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = arrayOf(ConstraintFragment.newInstance(),
        CoordinatorLayoutFragment.newInstance(),
        MotionLayoutFragment.newInstance())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}