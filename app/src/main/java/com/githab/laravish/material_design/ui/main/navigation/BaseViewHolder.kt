package com.githab.laravish.material_design.ui.main.navigation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.githab.laravish.material_design.ui.main.navigation.data.Date

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(data: Date)
}