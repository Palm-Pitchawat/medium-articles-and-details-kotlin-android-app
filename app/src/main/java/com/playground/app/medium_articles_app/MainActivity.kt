package com.playground.app.medium_articles_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.playground.app.medium_articles_app.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}