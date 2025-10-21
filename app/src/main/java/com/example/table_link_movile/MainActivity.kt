package com.example.table_link_movile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.table_link_movile.Data.remote.model.AppDatabase
import com.example.table_link_movile.ui.screens.UserScreen
import com.example.table_link_movile.ui.theme.TableLinkMovileTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = AppDatabase.getDatabase(application).userDao()
        val factory = UserViewModelFactory(dao)

        enableEdgeToEdge()
        setContent {
            val viewModel: UserViewModel = viewModel(factory = factory)
            TableLinkMovileTheme {
                UserScreen(viewModel)
            }
        }
    }
}