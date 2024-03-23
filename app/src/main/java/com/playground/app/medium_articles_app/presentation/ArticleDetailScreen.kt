package com.playground.app.medium_articles_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.playground.app.medium_articles_app.databinding.ArticleDetailScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleDetailScreen : Fragment() {

    private lateinit var binding: ArticleDetailScreenBinding
    private val articleDetailViewModel: ArticleDetailViewModel by viewModel()
    private val articleDetailScreenArgs: ArticleDetailScreenArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ArticleDetailScreenBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = articleDetailViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleDetailViewModel.setArticle(articleDetailScreenArgs.article)
    }
}