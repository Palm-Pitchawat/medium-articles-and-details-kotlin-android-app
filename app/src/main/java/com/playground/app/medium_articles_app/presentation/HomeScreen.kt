package com.playground.app.medium_articles_app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.playground.app.medium_articles_app.databinding.HomeScreenBinding
import com.playground.app.medium_articles_app.domain.model.Article
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreen : Fragment(), ArticleListener {

    private lateinit var binding: HomeScreenBinding
    private lateinit var navController: NavController
    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeScreenBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = homeViewModel
        }
        navController = findNavController()
        articleAdapter = ArticleAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.articlesDisplayList.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    override fun onArticleClicked(article: Article) {
        navController.navigate(
            HomeScreenDirections.actionHomeScreenToArticleDetailScreen(article)
        )
    }
}