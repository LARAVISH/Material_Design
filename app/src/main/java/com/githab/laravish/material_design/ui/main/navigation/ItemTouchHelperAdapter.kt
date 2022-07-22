package com.githab.laravish.material_design.ui.main.navigation

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun omItemDismiss(position: Int)
}