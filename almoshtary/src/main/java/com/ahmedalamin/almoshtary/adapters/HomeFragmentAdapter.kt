package com.ahmedalamin.almoshtary.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.ahmedalamin.almoshtary.R
import com.ahmedalamin.almoshtary.model.OrderData

class HomeFragmentAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OrderData>() {

        override fun areItemsTheSame(oldItem: OrderData, newItem: OrderData): Boolean {
            TODO("not implemented")
        }

        override fun areContentsTheSame(oldItem: OrderData, newItem: OrderData): Boolean {
            TODO("not implemented")
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HomeFragmentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.order_item_home_fragment,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeFragmentViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<OrderData>) {
        differ.submitList(list)
    }

    class HomeFragmentViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: OrderData):OrderData = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            TODO("bind view with data")
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: OrderData)
    }
}