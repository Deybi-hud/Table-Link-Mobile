package com.example.table_link_movile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.table_link_movile.data.repository.AuthRepository
import com.example.table_link_movile.navigation.AppNavGraph
import com.example.table_link_movile.ui.theme.TableLinkMovileTheme
import com.example.table_link_movile.viewmodel.AuthViewModel
import com.example.table_link_movile.viewmodel.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = AuthRepository(applicationContext)
        val authViewModel: AuthViewModel by viewModels {
            AuthViewModelFactory(repository)
        }

        val currentUser = FirebaseAuth.getInstance().currentUser
        val isLoggedIn = currentUser != null

        enableEdgeToEdge()
        setContent {
            TableLinkMovileTheme{
                AppNavGraph(
                    authViewModel = authViewModel,
                    isLoggedIn = isLoggedIn
                )
            }
        }
    }
}