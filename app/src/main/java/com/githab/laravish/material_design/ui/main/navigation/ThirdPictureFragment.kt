package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentThirdPictureBinding


class ThirdPictureFragment : Fragment() {

    private var _binding: FragmentThirdPictureBinding? = null
    private val binding: FragmentThirdPictureBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentThirdPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ThirdPictureFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
