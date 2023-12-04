package com.rudiridho.instanews.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rudiridho.instanews.R

class NewsCategoryAdapter(private val onItemClick: (String) -> Unit) : ListAdapter<String, NewsCategoryAdapter.NewsCategoryViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_category, parent, false)
        return NewsCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsCategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category, onItemClick)
    }

    class NewsCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryName: TextView = itemView.findViewById(R.id.categoryName)

        fun bind(category: String, onItemClick: (String) -> Unit) {
            categoryName.text = category
            itemView.setOnClickListener { onItemClick(category) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
