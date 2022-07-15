package com.githab.laravish.material_design.ui.main.animations

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2AnimationFragment(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = arrayOf(ExplodeFragment.newInstance(),
        TransformFragment.newInstance(),
        PathTransitionFragment.newInstance(),
        ShuffleFragment.newInstance(), ObjectAnimatorFragment.newInstance())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}