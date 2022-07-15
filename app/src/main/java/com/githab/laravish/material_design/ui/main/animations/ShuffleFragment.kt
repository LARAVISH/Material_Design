package com.githab.laravish.material_design.ui.main.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.githab.laravish.material_design.databinding.FragmentShuffleBinding

class ShuffleFragment : Fragment() {

    private var _binding: FragmentShuffleBinding? = null
    private val binding: FragmentShuffleBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentShuffleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shuffle()
    }

    private fun shuffle() = with(binding) {
        val titles: MutableList<String> = ArrayList()
        for (i in 0..4) {
            titles.add("Item $i")
        }
        buttonShuffle.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            transitionContainer.removeAllViews()
            titles.shuffle()
            titles.forEach {
                binding.transitionContainer.addView(TextView(requireContext()).apply {
                    text = it
                    ViewCompat.setTransitionName(this, it)//задали псевдоним
                })
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ShuffleFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
