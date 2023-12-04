package com.rudiridho.instanews.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class NewsSourcesResponse(val sources: List<NewsSource>)

@Parcelize
data class NewsSource(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
) : Parcelable
