package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.EARTH
import com.githab.laravish.material_design.MARS
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.SYSTEM
import com.githab.laravish.material_design.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding: FragmentViewPagerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = ViewPager2Adapter(this)
        bindTabLayout()
        setIcon()
    }

    private fun bindTabLayout() = with(binding) {
        TabLayoutMediator(tabLayout,
            viewPager2
        ) { tab, position ->
            tab.text = when (position) {
                0 -> EARTH
                1 -> MARS
                2 -> SYSTEM
                else -> {
                    EARTH
                }
            }
        }.attach()
    }

    private fun setIcon() = with(binding) {
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_mars)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_system)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ViewPagerFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
