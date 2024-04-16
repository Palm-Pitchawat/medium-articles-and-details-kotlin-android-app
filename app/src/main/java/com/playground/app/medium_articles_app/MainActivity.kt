package com.playground.app.medium_articles_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.playground.app.medium_articles_app.presentation.HomeScreen
import com.playground.app.medium_articles_app.presentation.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home",
                    ) {
                        composable(route = "home") {
                            HomeScreen()
                        }
                        composable(route = "articleDetail") {
                        }
                    }
                }
            }
        }
    }
}