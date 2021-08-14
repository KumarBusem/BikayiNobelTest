package com.busem.nobel.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.busem.data.models.Prize
import com.busem.nobel.databinding.ItemNobelPrizeBinding

class NobelAdapter(
    private val onPrizeSelected: (data: Prize) -> Unit
) : ListAdapter<Prize, NobelAdapter.NobelViewHolder>(DIFF) {

    override fun onCreateViewHolder(viewHolder: ViewGroup, viewType: Int): NobelViewHolder {
        return NobelViewHolder(
            ItemNobelPrizeBinding.inflate(
                LayoutInflater.from(viewHolder.context),
                viewHolder,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: NobelViewHolder, position: Int) {
        getItem(position)?.let { viewHolder.bind(it) }
    }

    inner class NobelViewHolder(private val item: ItemNobelPrizeBinding) :
        RecyclerView.ViewHolder(item.root) {

        init {
            item.cvNobelPrize.setOnClickListener {
                onPrizeSelected(getItem(adapterPosition))
            }
        }

        fun bind(hub: Prize) {
            item.data = hub
        }
    }

    companion object {

        val DIFF = object : DiffUtil.ItemCallback<Prize>() {

            override fun areItemsTheSame(old: Prize, new: Prize) = old.year == new.year

            override fun areContentsTheSame(old: Prize, new: Prize) = old == new
        }
    }
}