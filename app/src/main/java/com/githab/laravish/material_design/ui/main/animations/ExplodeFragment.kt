package com.githab.laravish.material_design.ui.main.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Explode
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.databinding.FragmentExplodeBinding


class ExplodeFragment : Fragment() {

    private var _binding: FragmentExplodeBinding? = null
    private val binding: FragmentExplodeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentExplodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = Adapter()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ExplodeFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.fragment_explode_item_recycler_view,
                    parent,
                    false
                ) as View
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                explode(it)
            }
        }

        override fun getItemCount() = 24

        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    }

    private fun explode(it: View) {
        val rec = Rect()
        it.getGlobalVisibleRect(rec)
        val explode = Explode().apply {
            duration = 2000L
            epicenterCallback = object : Transition.EpicenterCallback() {
                override fun onGetEpicenter(transition: Transition): Rect {
                    return rec
                }
            }
        }
        TransitionManager.beginDelayedTransition(binding.root, explode)
        binding.recyclerView.adapter = null
    }
}


