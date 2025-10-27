package com.example.table_link_movile.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.table_link_movile.navigation.NavHome
import com.example.table_link_movile.viewmodel.AuthViewModel

@Composable
fun HomeScreen(authViewModel: AuthViewModel, navHostControllerApp: NavHostController){
    NavHome(authViewModel, navHostControllerApp)
}