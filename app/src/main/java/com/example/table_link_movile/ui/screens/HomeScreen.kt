package com.example.table_link_movile.ui.screens

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope ()

    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ProfileMenu {
                onDismiss = {
                    scope.launch {
                        drawerState.close()
                    }
                }
            }
        }

    ) {


    }

}