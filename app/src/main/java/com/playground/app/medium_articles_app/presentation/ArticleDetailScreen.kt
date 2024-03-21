package com.playground.app.medium_articles_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.playground.app.medium_articles_app.databinding.ArticleDetailScreenBinding

class ArticleDetailScreen : Fragment() {

    private lateinit var binding: ArticleDetailScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ArticleDetailScreenBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}