package com.playground.app.medium_articles_app.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.playground.app.medium_articles_app.databinding.ArticleCardBinding
import com.playground.app.medium_articles_app.domain.model.Article

class ArticleAdapter(
    private val articleListener: ArticleListener
): ListAdapter<Article, ArticleAdapter.ArticleViewHolder>(PictureDiffCallBack()) {

    inner class ArticleViewHolder(val item: ArticleCardBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleCardBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.item.apply {
            article = getItem(position)
            listener = articleListener
            executePendingBindings()
        }
    }

    private class PictureDiffCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}

interface ArticleListener {
    fun onArticleClicked(article: Article)
}