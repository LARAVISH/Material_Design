package com.githab.laravish.material_design.ui.main.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.githab.laravish.material_design.*
import com.githab.laravish.material_design.databinding.FragmentFirstPictureBinding
import com.githab.laravish.material_design.ui.main.navigation.data.Date


class FirstPictureFragment : Fragment() {

    private var _binding: FragmentFirstPictureBinding? = null
    private val binding: FragmentFirstPictureBinding
        get() = _binding!!

    private lateinit var adapter: RecyclerViewAdapter
    private var isNewList = false

    private val date = arrayListOf(
        Pair(Date(0,NAME_HEADER, type = TYPE_HEADER), false),
        Pair(Date(1,NAME_MARS, type = TYPE_MARS), false),
        Pair(Date(2,NAME_MARS, type = TYPE_MARS), false),
        Pair(Date(3,NAME_EARTH, type = TYPE_EARTH), false),
        Pair(Date(4,NAME_MARS, type = TYPE_MARS), false),
        Pair(Date(5,NAME_EARTH, type = TYPE_EARTH), false),
        Pair(Date(6,NAME_EARTH, type = TYPE_EARTH), false),
        Pair(Date(7,NAME_MARS, type = TYPE_MARS), false),
        Pair(Date(8,NAME_EARTH, type = TYPE_EARTH), false),
        Pair(Date(9,NAME_EARTH, type = TYPE_EARTH), false),
        Pair(Date(10,NAME_MARS, type = TYPE_MARS), false)
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
        ItemTouchHelper(ItemTouchHelperCallBack(adapter)).attachToRecyclerView(binding.recyclerView)
        binding.recyclerActivityDiffUtilFAB.setOnClickListener {
            changeAdapterData()
        }
    }

    private val callbackAdd = AddItem {
        date.add(it, Pair(Date(name = "$NAME_MARS${"NEW"}", descriptionText =  "", type =  TYPE_MARS), false))
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

    private fun changeAdapterData() {
        adapter.setDataForDiffUtil(createItemList(isNewList).map { it }.toMutableList())
        isNewList = !isNewList
    }

    private fun createItemList(instanceNumber: Boolean): List<Pair<Date, Boolean>> {
        return when (instanceNumber) {
            false -> listOf(
                Pair(Date(0, "Header", type = TYPE_HEADER), false),
                Pair(Date(1, "Mars", ""), false),
                Pair(Date(2, "Mars", ""), false),
                Pair(Date(3, "Mars", ""), false),
                Pair(Date(4, "Mars", ""), false),
                Pair(Date(5, "Mars", ""), false),
                Pair(Date(6, "Mars", ""), false)
            )
            true -> listOf(
                Pair(Date(0, "Header",type = TYPE_HEADER), false),
                Pair(Date(1, "Mars", ""), false),
                Pair(Date(2, "Jupiter", ""), false),
                Pair(Date(3, "Mars", ""), false),
                Pair(Date(4, "Neptune", ""), false),
                Pair(Date(5, "Saturn", ""), false),
                Pair(Date(6, "Mars", ""), false)
            )
        }
    }
}
