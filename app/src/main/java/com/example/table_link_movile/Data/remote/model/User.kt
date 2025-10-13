package com.example.table_link_movile.Data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class User (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int
)