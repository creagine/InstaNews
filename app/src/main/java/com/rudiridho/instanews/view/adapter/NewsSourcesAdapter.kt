package com.rudiridho.instanews.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rudiridho.instanews.core.NewsSource
import com.rudiridho.instanews.R

class NewsSourcesAdapter(private val onItemClick: (NewsSource) -> Unit) : ListAdapter<NewsSource, NewsSourcesAdapter.NewsSourceViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_source, parent, false)
        return NewsSourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {
        val newsSource = getItem(position)
        holder.bind(newsSource, onItemClick)
    }

    class NewsSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sourceName: TextView = itemView.findViewById(R.id.sourceName)
        private val sourceDescription: TextView = itemView.findViewById(R.id.sourceDescription)

        fun bind(newsSource: NewsSource, onItemClick: (NewsSource) -> Unit) {
            sourceName.text = newsSource.name
            sourceDescription.text = newsSource.description

            itemView.setOnClickListener { onItemClick(newsSource) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NewsSource>() {
        override fun areItemsTheSame(oldItem: NewsSource, newItem: NewsSource): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsSource, newItem: NewsSource): Boolean {
            return oldItem == newItem
        }
    }
}
