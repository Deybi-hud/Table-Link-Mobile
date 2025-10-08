package com.example.table_link_movile.Data.model

import java.time.LocalDate

data class Historial (
    val id: Int,
    val fechaConversion: LocalDate,
    val tipoConverison: String,
    val descripcion: String,
    val usuario:Usuario
)