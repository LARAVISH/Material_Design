package com.githab.laravish.material_design.ui.main.navigation.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.githab.laravish.material_design.ui.main.navigation.data.Date

class DiffUtilCallBack(
    private val oldItems: List<Pair<Date, Boolean>>,
    private val newItems: List<Pair<Date, Boolean>>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].first.id == newItems[newItemPosition].first.id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].first.name == newItems[newItemPosition].first.name

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        val old = oldItems[oldItemPosition]
        val new = newItems[newItemPosition]

        return Change(old, new)
    }
}

data class Change<T>(val oldData: T, val newData: T)

fun <T> createCombinedPayload(payloads: List<Change<T>>): Change<T> {
    assert(payloads.isNotEmpty())
    val firstChange = payloads.first()
    val lastChange = payloads.last()
    return Change(firstChange.oldData, lastChange.newData)
}
