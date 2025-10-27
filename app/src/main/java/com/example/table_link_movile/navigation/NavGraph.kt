package com.example.table_link_movile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.table_link_movile.ui.screens.HomeScreen
import com.example.table_link_movile.ui.screens.LoginScreen
import com.example.table_link_movile.ui.screens.RegisterScreen
import com.example.table_link_movile.ui.screens.SplashScreen
import com.example.table_link_movile.viewmodel.AuthViewModel

@Composable
fun AppNavGraph(authViewModel: AuthViewModel, isLoggedIn: Boolean) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    )
    {
        composable("splash") {
            SplashScreen {
                if (isLoggedIn) navController.navigate("home") { popUpTo("splash") { inclusive = true } }
                else navController.navigate("home") { popUpTo("splash") { inclusive = true } }
            }
        }
        composable("login") {
            LoginScreen(
                onLogin = { email, pass -> authViewModel.login(email, pass)},
                onNavigateToRegister = { navController.navigate("register") },
                onSuccess ={
                    navController.navigate("home"){
                        popUpTo("login") {inclusive = true}
                    }

                },
                authViewModel = authViewModel

            )
        }
        composable("register"){
            RegisterScreen(
                onRegister = { email, pass, name ->
                    authViewModel.register(email, pass, name)
                },
                onBack = { navController.popBackStack() },
                onSuccess = {
                    navController.navigate("home") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                authViewModel = authViewModel
            )
        }

        composable("home") {
            HomeScreen(authViewModel = authViewModel, navHostControllerApp = navController)
        }
    }
}
