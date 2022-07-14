package com.githab.laravish.material_design.ui.main.animations

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.githab.laravish.material_design.databinding.FragmentPathTransitionBinding

class PathTransitionFragment : Fragment() {

    private var _binding: FragmentPathTransitionBinding? = null
    private val binding: FragmentPathTransitionBinding
        get() = _binding!!

    private var isFlag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPathTransitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPathButton()
    }

    private fun setPathButton() = with(binding) {

        button.setOnClickListener {
            val changeBounds = ChangeBounds().apply {
                setPathMotion(ArcMotion())
                duration = 500L
            }
            TransitionManager.beginDelayedTransition(
                root,
                changeBounds
            )
            isFlag = !isFlag
            val params = it.layoutParams as FrameLayout.LayoutParams
            if (isFlag) {
                params.gravity = Gravity.TOP or Gravity.START
            } else {
                params.gravity = Gravity.BOTTOM or Gravity.END
            }
            button.layoutParams = params
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PathTransitionFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
