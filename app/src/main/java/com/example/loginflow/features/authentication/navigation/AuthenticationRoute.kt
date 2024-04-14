package com.example.loginflow.features.authentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginflow.features.authentication.login.LoginScreen
import com.example.loginflow.features.authentication.signup.SignupScreen


@Composable
fun AuthenticationRoutes(){
    val navController= rememberNavController() // TO_DO why i need to create 2 nav controller
    return NavHost(navController = navController, startDestination = AuthenticationRoutesEnum.Signup.route){
        composable(AuthenticationRoutesEnum.Signup.route){
            SignupScreen()
        }
        composable(AuthenticationRoutesEnum.Login.route){
            LoginScreen()
        }
    }
}

enum class AuthenticationRoutesEnum(val route:String){
    Signup("signup"),
    Login("login")
}