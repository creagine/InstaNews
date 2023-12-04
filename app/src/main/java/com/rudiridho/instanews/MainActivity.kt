package com.rudiridho.instanews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rudiridho.instanews.core.NewsCategory
import com.rudiridho.instanews.view.NewsSourcesActivity
import com.rudiridho.instanews.view.adapter.NewsCategoryAdapter
import com.rudiridho.instanews.viewModel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = NewsCategoryAdapter { category ->
            showNewsSources(category)
        }

        val allCategories = getCategories()
        adapter.submitList(allCategories)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showNewsSources(category: String) {
        val intent = Intent(this, NewsSourcesActivity::class.java)
        intent.putExtra("selectedCategory", category)
        startActivity(intent)
    }

    private fun getCategories(): List<String> {
        return listOf(
            "Business",
            "Entertainment",
            "General",
            "Health",
            "Science",
            "Sports",
            "Technology"
        )
    }
}