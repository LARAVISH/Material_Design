package com.githab.laravish.material_design.ui.main.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentCoordinatorLayoutBinding

class CoordinatorLayoutFragment : Fragment() {

    private var _binding: FragmentCoordinatorLayoutBinding? = null
    private val binding: FragmentCoordinatorLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCoordinatorLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CoordinatorLayoutFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
