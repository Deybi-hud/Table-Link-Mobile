package com.example.table_link_movile.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
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
    var selectedDestination by rememberSaveable {mutableStateOf("home_user")}


    Scaffold(
        bottomBar = {
            NavigationBar(modifier = Modifier
                .height(80.dp)
                .shadow(4.dp),
                containerColor = MaterialTheme.colorScheme.background,
            ) {
                NavigationBarItem(
                    selected = selectedDestination == "home_user",
                    onClick = {
                        navController.navigate(route="home_user")
                        selectedDestination ="home_user"
                    },
                    icon = {
                      Box(
                            modifier = Modifier.size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "home_user",
                                modifier = Modifier
                                    .size(22.dp)

                            )
                            if(selectedDestination == "home_user"){
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primary,
                                            shape = CircleShape)
                                )
                            }
                        }
                    },
                    label = {Text("")},
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                )
                NavigationBarItem(
                    selected = selectedDestination == "profile",
                    onClick = {
                        navController.navigate("profile")
                        selectedDestination="profile"
                    },
                    icon = {
                        Box(
                           modifier = Modifier.size(40.dp),
                           contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "profile",
                                modifier = Modifier.size(22.dp)

                            )
                            if(selectedDestination == "profile"){
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primary,
                                            shape = CircleShape
                                        )
                                )
                            }
                        }
                    },
                    label = {Text("")},
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
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
