package com.rudiridho.instanews.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rudiridho.instanews.core.Article
import com.rudiridho.instanews.core.NewsCategory
import com.rudiridho.instanews.core.NewsSource
import com.rudiridho.instanews.core.RetrofitClient
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _topHeadlines = MutableLiveData<List<Article>>()
    val topHeadlines: LiveData<List<Article>> get() = _topHeadlines

    private val _newsCategories = MutableLiveData<List<NewsCategory>>()
    val newsCategories: LiveData<List<NewsCategory>> get() = _newsCategories

    private val _newsSources = MutableLiveData<List<NewsSource>>()
    val newsSources: LiveData<List<NewsSource>> get() = _newsSources

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val newsApiService = RetrofitClient.createNewsApiService()

    fun getTopHeadlines(apiKey: String, country: String) {
        viewModelScope.launch {
            try {
                val response = newsApiService.getTopHeadlines(apiKey, country)

                if (response.isSuccessful) {
                    _topHeadlines.value = response.body()?.articles
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun fetchNewsSources(categoryId: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = newsApiService.getNewsSources(apiKey, categoryId)

                if (response.isSuccessful) {
                    _newsSources.value = response.body()?.sources
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}

