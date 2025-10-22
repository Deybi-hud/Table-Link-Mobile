package com.example.table_link_movile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.table_link_movile.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AuthState{
    object Idle : AuthState()

    object Loading : AuthState()

    data class Success(val uid: String) : AuthState()

    data class Error(val message: String) : AuthState()
}

class AuthViewModel(private val repository: AuthRepository):  ViewModel(){

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> =_authState.asStateFlow()

    private val _currentUser = MutableStateFlow<String?>(null)
    val currentUid: StateFlow<String?> =_currentUser.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getUidFlow().collect { uid ->
                _currentUser.value = uid
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = repository.login(email, password)
            _authState.value = result.fold(
                onSuccess = {AuthState.Success(it)},
                onFailure = {AuthState.Error(it.message ?: "Unknown Error") }
            )
        }
    }

    fun register(email: String, password: String, name: String)  {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = repository.register(email, password, name)
            _authState.value = result.fold(
                onSuccess = {AuthState.Success(it)},
                onFailure = {AuthState.Error(it.message ?: "Unknown Error") }
            )
        }
    }

    fun logout(){
        viewModelScope.launch {
            repository.logout()
            _authState.value = AuthState.Idle
        }
    }

}