package com.githab.laravish.material_design.ui.main.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.databinding.FragmentConstraintBinding

class ConstraintFragment : Fragment() {

    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!

    private var flag = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnThird.setOnClickListener {
            flag = !flag
            binding.buttonGroup.visibility = if (flag) View.VISIBLE else View.INVISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ConstraintFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
