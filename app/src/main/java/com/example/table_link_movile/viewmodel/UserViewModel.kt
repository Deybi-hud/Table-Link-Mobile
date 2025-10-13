package com.example.table_link_movile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.table_link_movile.Data.remote.dao.UserDao
import com.example.table_link_movile.Data.remote.model.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(private val dao: UserDao): ViewModel() {

    val users = dao.getAllUsers().stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList())

    fun addUser(name: String, age: Int){
        viewModelScope.launch {
            dao.addUser(User(name = name, age = age))
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            dao.deleteUser(user)
        }
    }
}