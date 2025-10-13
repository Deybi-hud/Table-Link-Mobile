package com.example.table_link_movile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.table_link_movile.Data.remote.dao.UserDao

class UserViewModelFactory(private val dao: UserDao): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modeClass: Class<T>): T{
        if (modeClass.isAssignableFrom(UserViewModelFactory::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}