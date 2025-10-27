package com.example.table_link_movile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.table_link_movile.data.repository.AuthRepository
import com.example.table_link_movile.navigation.AppNavGraph
import com.example.table_link_movile.ui.theme.TableLinkMovileTheme
import com.example.table_link_movile.viewmodel.AuthViewModel
import com.example.table_link_movile.viewmodel.AuthViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = AuthRepository(applicationContext)
        val authViewModel: AuthViewModel by viewModels {
            AuthViewModelFactory(repository)
        }

        enableEdgeToEdge()
        setContent {
            TableLinkMovileTheme {
                val isLoggedIn by repository.getUidFlow().collectAsState(initial = null)
                AppNavGraph(
                    authViewModel = authViewModel,
                    isLoggedIn = isLoggedIn != null
                )
            }
        }
    }
}