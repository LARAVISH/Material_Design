package com.githab.laravish.material_design.ui.main.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.R

class CoordinatorLayoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_coordinator_layout, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CoordinatorLayoutFragment()
    }
}
