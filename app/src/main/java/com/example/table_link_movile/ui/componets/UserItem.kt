package com.example.table_link_movile.ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.table_link_movile.Data.remote.model.User

@Composable
fun UserItem(user: User, onDelete: (User) -> Unit){
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable{onDelete(user)},
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)){
            Text(text = user.name, style = MaterialTheme.typography.titleMedium )
            Text(text = "${user.age} años", style = MaterialTheme.typography.bodyMedium)
        }
    }
}