package com.githab.laravish.material_design.ui.main.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentTransformBinding


class TransformFragment : Fragment() {

    private var _binding: FragmentTransformBinding? = null
    private val binding: FragmentTransformBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransformBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TransformFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
