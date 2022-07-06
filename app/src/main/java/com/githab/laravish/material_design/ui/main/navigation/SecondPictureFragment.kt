package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentSecondPictureBinding


class SecondPictureFragment : Fragment() {

    private var _binding: FragmentSecondPictureBinding? = null
    private val binding: FragmentSecondPictureBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSecondPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SecondPictureFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

