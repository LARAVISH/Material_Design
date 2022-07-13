package com.githab.laravish.material_design.ui.main.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.ANIMATE_EXPLODE
import com.githab.laravish.material_design.ANIMATE_TRANSFORM
import com.githab.laravish.material_design.databinding.FragmentAnimationsBinding
import com.google.android.material.tabs.TabLayoutMediator


class AnimationsFragment : Fragment() {

    private var _binding: FragmentAnimationsBinding? = null
    private val binding: FragmentAnimationsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAnimationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = ViewPager2AnimationFragment(this)
        bindTab()
    }

    private fun bindTab() = with(binding) {
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> ANIMATE_EXPLODE
                1 -> ANIMATE_TRANSFORM

                else -> {
                    ANIMATE_EXPLODE
                }
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnimationsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
