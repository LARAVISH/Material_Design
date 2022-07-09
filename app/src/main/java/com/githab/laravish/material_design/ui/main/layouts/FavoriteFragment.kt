package com.githab.laravish.material_design.ui.main.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.databinding.FragmentFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator


class FavoriteFragment : Fragment() {

    private var _binding : FragmentFavoriteBinding? = null
    private val binding:FragmentFavoriteBinding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = ViewPager2FavoriteAdapter(this)
        bindTab()

    }

    private fun bindTab()  = with(binding){
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position ->
            tab.text = when(position){
                0 -> getString(R.string.constraint_layout)
                1 -> getString(R.string.coordinator_layout)
                2 -> getString(R.string.motion_layout)
                else -> {getString(R.string.constraint_layout)}
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FavoriteFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
