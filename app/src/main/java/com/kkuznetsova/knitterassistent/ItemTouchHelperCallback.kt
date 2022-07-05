package com.kkuznetsova.knitterassistent

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.kkuznetsova.knitterassistent.models.Marker

class ItemTouchHelperCallback(
    private val adapter: MarkerListAdapter,
    private val onDelete: (Marker) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    companion object {
        fun getInstance(adapter: MarkerListAdapter, onDelete: (Marker) -> Unit) =
            ItemTouchHelperCallback(adapter, onDelete)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val markerViewHolder = viewHolder as MarkerViewHolder
        onDelete(markerViewHolder.getData())
        adapter.notifyItemRemoved(markerViewHolder.bindingAdapterPosition)
    }
}

