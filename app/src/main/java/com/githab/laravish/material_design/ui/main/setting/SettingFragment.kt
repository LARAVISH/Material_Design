package com.githab.laravish.material_design.ui.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentSettingBinding
import com.google.android.material.tabs.TabLayout

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding: FragmentSettingBinding
        get() = _binding!!


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
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), tab?.text.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), tab?.text.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), tab?.text.toString(), Toast.LENGTH_LONG).show()
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