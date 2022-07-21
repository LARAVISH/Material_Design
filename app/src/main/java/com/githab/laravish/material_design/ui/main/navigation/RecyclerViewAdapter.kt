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

class RecyclerViewAdapter(
    private var listDate: MutableList<Date>,
    val callbackAdd: AddItem,
    val callbackRemove: RemoveItem,
) :
    RecyclerView.Adapter<BaseViewHolder>() {

    fun setAddDate(listDateNew: MutableList<Date>, position: Int) {
        listDate = listDateNew
        notifyItemInserted(position)
    }

    fun setRemoveDate(listDateNew: MutableList<Date>, position: Int) {
        listDate = listDateNew
        notifyItemRemoved(position)
    }


    override fun getItemViewType(position: Int): Int {
        return listDate[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(listDate[position])
    }

    override fun getItemCount() = listDate.size

    inner class MarsViewHolder(val binding: FragmentFirstPictureMarsBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Date) = with(binding) {
            name.text = data.name
            addItemImageView.setOnClickListener {
                callbackAdd.add(layoutPosition)
            }
            removeItemImageView.setOnClickListener {
                callbackRemove.remove(layoutPosition)
            }
            moveItemUp.setOnClickListener {
                listDate.removeAt(layoutPosition).apply {
                    listDate.add(layoutPosition - 1, this)
                }
                notifyItemMoved(layoutPosition, layoutPosition - 1)
            }
            moveItemDown.setOnClickListener {
                listDate.removeAt(layoutPosition).apply {
                    listDate.add(layoutPosition + 1, this)
                }
                notifyItemMoved(layoutPosition, layoutPosition + 1)
            }
        }
    }

    inner class EarthViewHolder(val binding: FragmentFirstPictureEarthBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Date) = with(binding) {
            name.text = data.name
        }
    }

    inner class HeaderViewHolder(val binding: FragmentFirstPictureHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Date) = with(binding) {
            name.text = data.name
        }
    }
}