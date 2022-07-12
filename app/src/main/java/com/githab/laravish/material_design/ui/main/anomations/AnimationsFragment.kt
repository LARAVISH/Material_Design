package com.githab.laravish.material_design.ui.main.anomations

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.Slide
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.githab.laravish.material_design.databinding.FragmentAnimationsBinding

class AnimationsFragment : Fragment() {

    private var _binding: FragmentAnimationsBinding? = null
    private val binding: FragmentAnimationsBinding
        get() = _binding!!

    private var isFlag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAnimationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeBounds()
    }

    private fun changeBounds() = with(binding) {
        binding.btnOne.setOnClickListener {
            isFlag = !isFlag

            TransitionManager.beginDelayedTransition(binding.root, TransitionSet().apply {
                ordering = TransitionSet.ORDERING_SEQUENTIAL
                val slide = Slide(Gravity.START)
                slide.duration = 1000L
                val changeBounds = ChangeBounds()
                changeBounds.duration = 1000L
                addTransition(changeBounds)
                addTransition(slide)
            })
            text.visibility = if (isFlag) View.VISIBLE else View.GONE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnimationsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
