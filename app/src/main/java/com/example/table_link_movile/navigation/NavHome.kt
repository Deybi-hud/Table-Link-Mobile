package com.example.table_link_movile.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.table_link_movile.ui.screens.user.HomeScreen
import com.example.table_link_movile.ui.screens.user.ProfileScreen
import com.example.table_link_movile.viewmodel.AuthViewModel


@Composable
fun NavHome(authViewModel: AuthViewModel, navControllerApp: NavHostController) {

    val navController = rememberNavController()
    var selectedDestination by rememberSaveable { mutableStateOf("home_user") }


    Scaffold(
        containerColor = Blue,
        bottomBar = {

            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets, containerColor = Blue,
                contentColor = Gray) {
                NavigationBarItem(
                    selected = selectedDestination == "home_user",
                    onClick = {
                        navController.navigate(route="home_user")
                        selectedDestination ="user_home"
                    },
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription ="home_user"
                        )
                    },
                    label = {Text("Inicio")},
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = White,
                        selectedTextColor = White,
                        unselectedIconColor = Gray,
                        unselectedTextColor = Gray,

                    )
                )
                NavigationBarItem(
                    selected = selectedDestination =="profile",
                    onClick = {
                        navController.navigate("profile")
                        selectedDestination="profile"
                    },
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Perfil"
                        )
                    },
                    label = {Text("Perfil")},
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = White,
                        selectedTextColor = White,
                        unselectedIconColor = Gray,
                        unselectedTextColor = Gray,

                    )

                )

            }
        }
    ){
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home_user",
            modifier = Modifier.padding(innerPadding)
        ){
            composable("home_user"){ HomeScreen() }
            composable("profile"){ ProfileScreen(authViewModel,navControllerApp)}
        }
    }
}
