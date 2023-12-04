package com.rudiridho.instanews.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class NewsCategoriesResponse(val sources: List<NewsCategory>)

@Parcelize
data class NewsCategory(val id: String, val name: String, val category: String) : Parcelable
