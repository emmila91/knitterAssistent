package com.kkuznetsova.knitterassistent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kkuznetsova.knitterassistent.databinding.MarkerRecyclerViewItemBinding
import com.kkuznetsova.knitterassistent.models.Marker

class MarkerViewHolder(private val binding: MarkerRecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(marker: Marker) {
        binding.marker = marker
    }
}

class MarkerListAdapter(private val items: List<Marker>) :
    RecyclerView.Adapter<MarkerViewHolder>() {

    private lateinit var binding: MarkerRecyclerViewItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkerViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.marker_recycler_view_item,
            parent,
            false
        )
        return MarkerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarkerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}