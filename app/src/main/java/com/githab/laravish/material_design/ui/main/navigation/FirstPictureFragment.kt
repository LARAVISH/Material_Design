package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.githab.laravish.material_design.databinding.FragmentFirstPictureBinding


class FirstPictureFragment : Fragment() {

    private var _binding: FragmentFirstPictureBinding? = null
    private val binding: FragmentFirstPictureBinding
        get() = _binding!!

    private var isFlag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentFirstPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transformImage()
    }

    private fun transformImage() = with(binding) {
        imageViewFirst.setOnClickListener {
            isFlag = !isFlag
            val params: ViewGroup.LayoutParams = imageViewFirst.layoutParams
            val transitionSet = TransitionSet().apply {
                duration = 2000L
                ordering = TransitionSet.ORDERING_TOGETHER
                addTransition(ChangeTransform())
                addTransition(ChangeImageTransform())
            }
            TransitionManager.beginDelayedTransition(root, transitionSet)
            if (isFlag) {
                params.height = LinearLayout.LayoutParams.MATCH_PARENT
                imageViewFirst.scaleType = ImageView.ScaleType.CENTER_CROP
            } else {
                params.height = LinearLayout.LayoutParams.WRAP_CONTENT
                imageViewFirst.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
            imageViewFirst.layoutParams = params
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstPictureFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
