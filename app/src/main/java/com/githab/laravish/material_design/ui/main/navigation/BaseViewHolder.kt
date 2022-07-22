package com.githab.laravish.material_design.ui.main.navigation

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.ui.main.navigation.data.Date

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view),
    ItemTouchHelperViewHolder {
    abstract fun bind(data: Pair<Date, Boolean>)

    override fun onItemSelected() {
        itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.red))
    }

    override fun onItemClear() {
        itemView.setBackgroundColor(0)
    }
}