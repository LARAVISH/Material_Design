package com.githab.laravish.material_design.ui.main.navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.TYPE_EARTH
import com.githab.laravish.material_design.TYPE_MARS
import com.githab.laravish.material_design.databinding.FragmentFirstPictureEarthBinding
import com.githab.laravish.material_design.databinding.FragmentFirstPictureHeaderBinding
import com.githab.laravish.material_design.databinding.FragmentFirstPictureMarsBinding
import com.githab.laravish.material_design.ui.main.navigation.data.Date
import com.githab.laravish.material_design.ui.main.navigation.diffutil.Change
import com.githab.laravish.material_design.ui.main.navigation.diffutil.DiffUtilCallBack
import com.githab.laravish.material_design.ui.main.navigation.diffutil.createCombinedPayload

class RecyclerViewAdapter(
    private var listDate: MutableList<Pair<Date, Boolean>>,
    val callbackAdd: AddItem,
    val callbackRemove: RemoveItem,
) :
    RecyclerView.Adapter<BaseViewHolder>(), ItemTouchHelperAdapter {

    fun setDataForDiffUtil(newListData: MutableList<Pair<Date, Boolean>>) {
        val diff = DiffUtil.calculateDiff(DiffUtilCallBack(listDate, newListData))
        diff.dispatchUpdatesTo(this)
        listDate = newListData
    }

    fun setAddDate(listDateNew: MutableList<Pair<Date, Boolean>>, position: Int) {
        listDate = listDateNew
        notifyItemInserted(position)
    }

    fun setRemoveDate(listDateNew: MutableList<Pair<Date, Boolean>>, position: Int) {
        listDate = listDateNew
        notifyItemRemoved(position)
    }

    override fun getItemViewType(position: Int): Int {
        return listDate[position].first.type
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

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val createCombinedPayload =
                createCombinedPayload(payloads as List<Change<Pair<Date, Boolean>>>)
            if (createCombinedPayload.oldData.first.name != createCombinedPayload.newData.first.name)
                holder.itemView.findViewById<TextView>(R.id.name).text =
                    createCombinedPayload.newData.first.name
        }
    }

    override fun getItemCount() = listDate.size

    inner class MarsViewHolder(val binding: FragmentFirstPictureMarsBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Date, Boolean>) = with(binding) {
            name.text = data.first.name
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
            marsDescriptionTextView.visibility = if (listDate[layoutPosition].second) View.VISIBLE
            else View.GONE
            marsImageView.setOnClickListener {
                listDate[layoutPosition] = listDate[layoutPosition].let {
                    it.first to !it.second
                }
                notifyItemChanged(layoutPosition)
            }
        }
    }

    inner class EarthViewHolder(val binding: FragmentFirstPictureEarthBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Date, Boolean>) = with(binding) {
            name.text = data.first.name
        }
    }

    inner class HeaderViewHolder(val binding: FragmentFirstPictureHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Date, Boolean>) = with(binding) {
            name.text = data.first.name
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        listDate.removeAt(fromPosition).apply {
            listDate.add(toPosition, this)
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun omItemDismiss(position: Int) {
        callbackRemove.remove(position)
    }
}