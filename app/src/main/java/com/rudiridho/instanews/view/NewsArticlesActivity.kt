package com.rudiridho.instanews.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rudiridho.instanews.R
import com.rudiridho.instanews.core.NewsSource

class NewsArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_articles)

        val selectedSource: NewsSource? = intent.getParcelableExtra("selectedSource")

        // Check if a source was provided
        if (selectedSource != null) {
            supportActionBar?.title = selectedSource.name

            // You can use the selected source to fetch and display news articles
            // For example, you might make another API call here or load a WebView with the news source's URL.
            // Here, we'll just display the source description as a placeholder.
            val sourceDescriptionTextView: TextView = findViewById(R.id.sourceDescriptionTextView)
            sourceDescriptionTextView.text = selectedSource.description
        } else {
            // Handle the case where no source was provided
            finish() // Close the activity if no source is available
        }
    }
}
