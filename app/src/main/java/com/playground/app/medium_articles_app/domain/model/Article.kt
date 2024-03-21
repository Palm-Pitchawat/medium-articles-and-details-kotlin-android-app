package com.playground.app.medium_articles_app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String,
    val image: String,
    val imageReference: String,
    val htmlContent: String,
    val content: String
) : Parcelable
