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

    private lateinit var adapter: RecyclerViewAdapter

    private val date = arrayListOf(
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFirstPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecyclerViewAdapter(date, callbackAdd, callbackRemove)
        binding.recyclerView.adapter = adapter
    }

    private val callbackAdd = AddItem {
        date.add(it, Date("$NAME_MARS${"NEW"}", TYPE_MARS))
        adapter.setAddDate(date, it)
    }

    private val callbackRemove = RemoveItem {
        date.removeAt(it)
        adapter.setRemoveDate(date, it)
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
