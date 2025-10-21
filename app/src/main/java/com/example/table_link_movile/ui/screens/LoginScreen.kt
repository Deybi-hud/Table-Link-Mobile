package com.example.table_link_movile.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Login(Modifier.align(Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column(modifier = modifier){
        Spacer(Modifier.padding(16.dp))
        EmailField()
        Spacer(Modifier.padding(4.dp))
        PasswordField()
        Spacer(Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(Modifier.padding(16.dp))
        LoginButton()
    }
}

@Composable
fun LoginButton() {
    Button(onClick = { }, Modifier.
    fillMaxWidth().
    height(48.dp),
    colors = ButtonDefaults.buttonColors())
    {
        Text(text="Iniciar sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text="¿Olvido su contraseña?", modifier = Modifier.clickable{ }, fontSize = 12.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun PasswordField() {
    TextField(value = "", onValueChange ={},
    placeholder = {Text(text = "Contraseña")},
    modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(Color(0xFFD0BCFF))
    )
}

@Composable
fun EmailField(){
    TextField(value = "",onValueChange={},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(Color(0xFFD0BCFF))
    )
}