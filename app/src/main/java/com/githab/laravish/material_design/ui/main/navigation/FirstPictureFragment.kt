package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.*
import com.githab.laravish.material_design.databinding.FragmentFirstPictureBinding
import com.githab.laravish.material_design.ui.main.navigation.data.Date


class FirstPictureFragment : Fragment() {

    private var _binding: FragmentFirstPictureBinding? = null
    private val binding: FragmentFirstPictureBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFirstPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listDate = arrayListOf(
            Date(NAME_HEADER, TYPE_HEADER),
            Date(NAME_MARS, TYPE_MARS),
            Date(NAME_MARS, TYPE_MARS),
            Date(NAME_EARTH, TYPE_EARTH),
            Date(NAME_MARS, TYPE_MARS),
            Date(NAME_EARTH, TYPE_EARTH),
            Date(NAME_EARTH, TYPE_EARTH),
            Date(NAME_MARS, TYPE_MARS),
            Date(NAME_EARTH, TYPE_EARTH),
            Date(NAME_EARTH, TYPE_EARTH),
            Date(NAME_MARS, TYPE_MARS)
        )
        binding.recyclerView.adapter = RecyclerViewAdapter(listDate)
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
