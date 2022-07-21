package com.githab.laravish.material_design.ui.main.navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.githab.laravish.material_design.TYPE_EARTH
import com.githab.laravish.material_design.TYPE_MARS
import com.githab.laravish.material_design.databinding.FragmentFirstPictureEarthBinding
import com.githab.laravish.material_design.databinding.FragmentFirstPictureHeaderBinding
import com.githab.laravish.material_design.databinding.FragmentFirstPictureMarsBinding
import com.githab.laravish.material_design.ui.main.navigation.data.Date

class RecyclerViewAdapter(private val listDate: List<Date>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return listDate[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_MARS -> {
                val binding =
                    FragmentFirstPictureMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(binding)
            }
            TYPE_EARTH -> {
                val binding =
                    FragmentFirstPictureEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(binding)
            }
            else -> {
                val binding =
                    FragmentFirstPictureHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount() = listDate.size

    inner class MarsViewHolder(val binding: FragmentFirstPictureMarsBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class EarthViewHolder(val binding: FragmentFirstPictureEarthBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class HeaderViewHolder(val binding: FragmentFirstPictureHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

}