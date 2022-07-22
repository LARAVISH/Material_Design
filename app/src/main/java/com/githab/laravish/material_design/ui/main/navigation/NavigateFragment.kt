package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.databinding.FragmentNavigateBinding
import com.githab.laravish.material_design.ui.main.animations.AnimationsFragment
import com.githab.laravish.material_design.ui.main.layouts.FavoriteFragment
import com.githab.laravish.material_design.ui.main.pictures.PictureOfTheDayFragment
import com.githab.laravish.material_design.ui.main.setting.SettingFragment
import com.google.android.material.badge.BadgeDrawable

class NavigateFragment : Fragment() {

    private var _binding: FragmentNavigateBinding? = null
    private val binding: FragmentNavigateBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNavigateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigationBarMenu()
        createdBadge()
    }

    private fun createdBadge() = with(binding) {
        navigationBar.getOrCreateBadge(R.id.action_favorite).apply {
            number = 50
            maxCharacterCount = 3
            badgeGravity = BadgeDrawable.TOP_END
        }
    }

    private fun initNavigationBarMenu() = with(binding) {
        navigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    navigateTo(PictureOfTheDayFragment.newInstance())
                }
                R.id.action_gallery -> {
                    navigateTo(ViewPagerFragment.newInstance())
                }
                R.id.action_favorite -> {
                    navigateTo(FavoriteFragment.newInstance())
                }
                R.id.action_setting -> {
                    navigateTo(SettingFragment.newInstance())
                }
                R.id.action_animation -> {
                    navigateTo(AnimationsFragment.newInstance())
                }
            }
            true
        }
        navigationBar.selectedItemId = R.id.action_gallery

    }

    private fun navigateTo(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_view, fragment).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() =
            NavigateFragment()
    }
}
