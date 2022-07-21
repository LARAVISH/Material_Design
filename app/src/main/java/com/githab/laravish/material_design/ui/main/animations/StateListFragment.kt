package com.githab.laravish.material_design.ui.main.animations

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentStateListBinding


class StateListFragment : Fragment() {
    private var _binding: FragmentStateListBinding? = null
    private val binding: FragmentStateListBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStateListBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StateListFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
