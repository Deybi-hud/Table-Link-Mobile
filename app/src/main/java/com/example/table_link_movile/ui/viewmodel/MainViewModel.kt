package com.example.table_link_movile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Modelo de datos para usuarios
data class UserData(
    val nombre: String,
    val apellido: String,
    val tipoUsuario: TipoUsuario
)

enum class TipoUsuario {
    NORMAL,
    VIP
}

// Estado de la conversión
data class ConversionState(
    val isLoading: Boolean = false,
    val usuarios: List<UserData> = emptyList(),
    val errorMessage: String? = null
)

class MainViewModel : ViewModel() {
    private val _conversionState = MutableStateFlow(ConversionState())
    val conversionState: StateFlow<ConversionState> = _conversionState.asStateFlow()

    private val _historialConversiones = MutableStateFlow<List<String>>(emptyList())
    val historialConversiones: StateFlow<List<String>> = _historialConversiones.asStateFlow()

    fun uploadSqlFile(filePath: String) {
        viewModelScope.launch {
            _conversionState.value = _conversionState.value.copy(isLoading = true)

            // Aquí irá la lógica de conversión SQL a Excel
            // Por ahora solo es la estructura

            _conversionState.value = _conversionState.value.copy(isLoading = false)
        }
    }

    fun convertToExcel(usuarios: List<UserData>) {
        viewModelScope.launch {
            // Lógica de conversión a Excel
            // Se implementará más adelante
        }
    }

    fun addToHistorial(conversion: String) {
        _historialConversiones.value = _historialConversiones.value + conversion
    }

    fun clearError() {
        _conversionState.value = _conversionState.value.copy(errorMessage = null)
    }
}