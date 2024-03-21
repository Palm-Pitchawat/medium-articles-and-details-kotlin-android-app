package com.playground.app.medium_articles_app.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fleeksoft.ksoup.Ksoup
import com.playground.app.medium_articles_app.domain.model.Article

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    Glide.with(imageView)
        .load(imageUrl)
        .into(imageView)
}
@BindingAdapter("submitArticleList")
fun submitArticleList(recyclerView: RecyclerView, articleList: List<Article>?) {
    val adapter = recyclerView.adapter as ArticleAdapter
    adapter.submitList(articleList)
}
@BindingAdapter("setArticleContent")
fun setArticleContent(textView: TextView, htmlText: String?) {
    if (htmlText != null) {
        textView.text = Ksoup.parse(htmlText).text()
    }
}
@BindingAdapter("setArticleChannelTitle")
fun setArticleChannelTitle(textView: TextView, articleChannelTitle: String?) {
    if (articleChannelTitle != null) {
        textView.text = articleChannelTitle
        textView.visibility = View.VISIBLE
    } else {
        textView.visibility = View.GONE
        textView.text = null
    }
}