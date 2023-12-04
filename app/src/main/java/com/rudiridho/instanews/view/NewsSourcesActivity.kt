package com.rudiridho.instanews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rudiridho.instanews.core.NewsCategory
import com.rudiridho.instanews.view.adapter.NewsSourcesAdapter
import com.rudiridho.instanews.viewModel.NewsViewModel
import com.rudiridho.instanews.R

class NewsSourcesActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_sources)

        val newsSourcesAdapter = NewsSourcesAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewNewsSources)
        recyclerView.adapter = newsSourcesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val selectedCategory = intent.getStringExtra("selectedCategory")

        viewModel.newsSources.observe(this) { sources ->
            newsSourcesAdapter.submitList(sources)
        }

        viewModel.error.observe(this) {
        }

        // Call the API to get news categories
        if (selectedCategory != null) {
            viewModel.fetchNewsSources(selectedCategory ,"b3bc3e676c1341afaae60cf01bfb1d41")
        }
    }
}
