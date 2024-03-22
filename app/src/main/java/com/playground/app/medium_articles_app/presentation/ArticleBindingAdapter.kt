package com.playground.app.medium_articles_app.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
    if (!articleList.isNullOrEmpty()) {
        adapter.submitList(articleList)
    }
}

@BindingAdapter("setDisableAllItem")
fun setDisableAllItem(recyclerView: RecyclerView, loading: Boolean) {
    val adapter = recyclerView.adapter as ArticleAdapter
    adapter.disableAllItem(loading)
}

@BindingAdapter("setDisable")
fun setDisable(view: View, disable: Boolean) {
    view.isEnabled = !disable
}

@BindingAdapter("setArticleContent")
fun setArticleContent(textView: TextView, content: String?) {
    textView.text = content
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
@BindingAdapter("setProgressBarVisibility")
fun setProgressBarVisibility(view: View, loading: Boolean) {
    if (loading) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}