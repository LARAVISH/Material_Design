package com.githab.laravish.material_design.ui.main.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.githab.laravish.material_design.databinding.FragmentTransformBinding


class TransformFragment : Fragment() {

    private var _binding: FragmentTransformBinding? = null
    private val binding: FragmentTransformBinding
        get() = _binding!!

    private var isExpanded = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransformBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transformsImageView()
    }

    private fun transformsImageView() = with(binding) {
        binding.imageView.setOnClickListener {
            isExpanded = !isExpanded
            val param: ViewGroup.LayoutParams = imageView.layoutParams

            val transitionSet = TransitionSet().apply {
                duration = 3000L
                ordering = TransitionSet.ORDERING_TOGETHER
                addTransition(ChangeBounds())
                addTransition(ChangeImageTransform())
            }

            TransitionManager.beginDelayedTransition(binding.root, transitionSet)
            if (isExpanded) {
                param.height = LinearLayout.LayoutParams.MATCH_PARENT
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            } else {
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
            binding.imageView.layoutParams = param
        }
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
