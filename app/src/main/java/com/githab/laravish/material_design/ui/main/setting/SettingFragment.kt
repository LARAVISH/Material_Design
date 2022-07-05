package com.githab.laravish.material_design.ui.main.setting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.MainActivity
import com.githab.laravish.material_design.THEME_BROWN
import com.githab.laravish.material_design.THEME_DEFAULT
import com.githab.laravish.material_design.THEME_GREEN
import com.githab.laravish.material_design.databinding.FragmentSettingBinding
import com.google.android.material.tabs.TabLayout

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding: FragmentSettingBinding
        get() = _binding!!

    lateinit var parentActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = requireActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedTabClick()
    }

    private fun selectedTabClick() = with(binding) {
        when ((parentActivity.getCurrentTheme())) {
            THEME_DEFAULT -> {
                tabLayout.selectTab(tabLayout.getTabAt(0))
            }
            THEME_BROWN -> {
                tabLayout.selectTab(tabLayout.getTabAt(1))
            }
            THEME_GREEN -> {
                tabLayout.selectTab(tabLayout.getTabAt(2))
            }
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        parentActivity.setCurrentTheme(THEME_DEFAULT)
                        parentActivity.recreate()
                    }
                    1 -> {
                        parentActivity.setCurrentTheme(THEME_BROWN)
                        parentActivity.recreate()
                    }
                    2 -> {
                        parentActivity.setCurrentTheme(THEME_GREEN)
                        parentActivity.recreate()
                    }
                }
                requireActivity().recreate()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = SettingFragment()
    }
}