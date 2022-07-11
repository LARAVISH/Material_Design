package com.githab.laravish.material_design.ui.main.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentMotionLayoutBinding


class MotionLayoutFragment : Fragment() {

    private var _binding: FragmentMotionLayoutBinding? = null
    private val binding: FragmentMotionLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentMotionLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            MotionLayoutFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
