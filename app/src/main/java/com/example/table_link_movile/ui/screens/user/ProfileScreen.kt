package com.example.table_link_movile.ui.screens.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.table_link_movile.ui.theme.Gray21
import com.example.table_link_movile.viewmodel.AuthViewModel

@Composable
fun ProfileScreen(authViewModel: AuthViewModel, navControllerApp: NavHostController) {

    val authState by authViewModel.authState.collectAsState()

    val userName by authViewModel.userNameFlow.collectAsState(initial = "")
    val userEmail by authViewModel.userEmailFlow.collectAsState(initial = "")

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Perfil",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )

        Spacer(Modifier.height(24.dp))

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Icono de perfil",
            modifier = Modifier.size(96.dp),
            tint = Gray21
        )

        Spacer(Modifier.height(50.dp))

        Text(
            text = "Nombre: ${if (userName.isNullOrBlank()) "-" else userName}",
            fontSize = 18.sp,
            color = Black
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Correo: ${if (userEmail.isNullOrBlank()) "-" else userEmail}",
            fontSize = 18.sp,
            color = Black
        )

        Spacer(Modifier.height(150.dp))

        Button(
            onClick = {
                try {
                    navControllerApp.navigate("record")
                } catch (error: Exception) {}
            },
            colors = ButtonDefaults.buttonColors(containerColor = Gray),
            modifier = Modifier
                .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
        ) {
            Text("Historial de conversiones", color = White)
        }
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = {
                try {
                    authViewModel.logout()
                    navControllerApp.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                } catch (error: Exception) {

                }

            },
            colors = ButtonDefaults.buttonColors(containerColor = Gray),
            modifier = Modifier
                .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
        ){
            Text("Cerrar sesión", color = White)
        }
    }
}