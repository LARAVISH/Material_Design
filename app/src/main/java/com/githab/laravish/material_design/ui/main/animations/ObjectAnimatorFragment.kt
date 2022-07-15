package com.githab.laravish.material_design.ui.main.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.*
import com.githab.laravish.material_design.databinding.FragmentObjectAnimatorBinding

class ObjectAnimatorFragment : Fragment() {

    private var _binding: FragmentObjectAnimatorBinding? = null
    private val binding: FragmentObjectAnimatorBinding
        get() = _binding!!
    private var isFlag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentObjectAnimatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            isFlag = !isFlag
            if (isFlag) {
                ObjectAnimator.ofFloat(binding.plusImageview,
                    View.ROTATION,
                    rotationFrom,
                    rotationTo).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,
                    View.TRANSLATION_Y,
                    translationOneContainer).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,
                    View.TRANSLATION_Y,
                    translationTwoContainer).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.transparentBackground,
                    View.ALPHA,
                    alpha_transparentBackground).setDuration(duration).start()
                binding.optionOneContainer.animate().alpha(alpha_optionOneContainer)
                    .setDuration(duration).setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                binding.optionOneContainer.isClickable = true
                            }
                        }
                    )
                binding.optionTwoContainer.animate().alpha(alpha_optionTwoContainer)
                    .setDuration(duration).setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                binding.optionTwoContainer.isClickable = true
                            }
                        }
                    )

            } else {

                ObjectAnimator.ofFloat(binding.plusImageview,
                    View.ROTATION,
                    closedRotationFrom,
                    closedRotationTo).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,
                    View.TRANSLATION_Y,
                    closed_translationOneContainer).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,
                    View.TRANSLATION_Y,
                    closed_translationTwoContainer).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.transparentBackground,
                    View.ALPHA,
                    closed_alpha_transparentBackground).setDuration(duration).start()

                binding.optionOneContainer.animate().alpha(closed_alpha_optionOneContainer)
                    .setDuration(duration).setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                binding.optionOneContainer.isClickable = false
                            }
                        }
                    )

                binding.optionTwoContainer.animate().alpha(closed_alpha_optionTwoContainer)
                    .setDuration(duration).setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                binding.optionTwoContainer.isClickable = false
                            }
                        }
                    )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ObjectAnimatorFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
