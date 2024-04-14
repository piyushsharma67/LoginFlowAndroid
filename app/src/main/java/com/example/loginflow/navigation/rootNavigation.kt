package com.example.loginflow.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginflow.RootViewModel
import com.example.loginflow.features.authenticated.HomeScreen
import com.example.loginflow.features.authentication.navigation.AuthenticationRoutes
import com.example.loginflow.utils.GenericResult

@Composable
fun RootNavigation(startDestination:String){

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        composable(RootRoutesEnums.Authentication.route) {
            AuthenticationRoutes()
        }
        composable(RootRoutesEnums.Authenticated.route) {
            HomeScreen()
        }
    }
}

enum class RootRoutesEnums(val route:String){
    Authentication("authentication"),
    Authenticated("authenticated")
}