package com.example.a211412_danishdanial_nelsonsana_project1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.*
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a211412_danishdanial_nelsonsana_project1.screen.*
import com.example.a211412_danishdanial_nelsonsana_project1.UserViewModel
import com.example.a211412_danishdanial_nelsonsana_project1.components.AppBottomNavigation

@Composable
fun KasihNavigation() {
    val navController = rememberNavController()
    val viewModel: UserViewModel = viewModel()

    Scaffold(
        bottomBar = { AppBottomNavigation(navController) }
    ) { innerPadding ->

        NavHost(navController, startDestination = "home") {

            composable("home") {
                HomeScreen(navController, viewModel, innerPadding)
            }

            composable("add") {
                AddScreen(navController, innerPadding)
            }

            composable("profile") {
                ProfileScreen(navController, viewModel, innerPadding)
            }

            composable("details/{foodName}") {
                val food = it.arguments?.getString("foodName") ?: ""
                FoodDetailsScreen(navController, food, innerPadding)
            }

            composable("booking/{foodName}") {
                val food = it.arguments?.getString("foodName") ?: ""
                BookingScreen(navController, food, viewModel, innerPadding)
            }

            composable("summary") {
                SummaryScreen(navController, viewModel, innerPadding)
            }

            composable("search/{query}") {
                val query = it.arguments?.getString("query") ?: ""
                SearchScreen(navController, query)
            }
        }
    }
}