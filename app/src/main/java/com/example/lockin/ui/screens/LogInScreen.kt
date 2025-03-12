package com.example.lockin.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.fontResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.example.lockin.R
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.background

// Definir la fuente correctamente
@Composable
fun LogInScreen(navController: NavController) {

    val gradientColors = listOf(
        Color(0x0C52BFBA), // 3% Opacidad
        Color(0x176DA0E4), // 9% Opacidad
        Color(0x0C5952E7), // 3% Opacidad
        Color(0x11E551E0), // 7% Opacidad
        Color(0x03C91F22)  // 1% Opacidad
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
                .padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Inicia sesión",
            fontSize = 32.sp,
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "¡Qué bueno verte de nuevo!",
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campos de usuario y contraseña
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Usuario") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth() // Hace que el campo de texto tenga el mismo ancho que los botones
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de continuar
        Button(
            onClick = { /* Acción de login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Continuar", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Línea divisoria con "o"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp), // Espaciado arriba y abajo
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = Color.Gray
            )
            Text(
                text = "o",
                modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 16.sp,
                color = Color.Gray
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = Color.Gray
            )
        }
        // Botones de inicio de sesión con Apple y Google
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón de Apple
            Button(
                onClick = { /* Acción Apple */ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White, // Fondo blanco
                    contentColor = Color.Black    // Texto negro
                ),
                border = BorderStroke(2.dp, Color.Black), // Borde negro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.apple_logo),
                    contentDescription = "Apple",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black // Color del icono en negro
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Continue with Apple", color = Color.Black) // Texto negro
            }


            // Botón de Google
            // Botón de Google
            Button(
                onClick = { /* Acción Google */ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White, // Fondo blanco
                    contentColor = Color.Black    // Texto negro
                ),
                border = BorderStroke(2.dp, Color.Black), // Borde negro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black // Color del icono en negro
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Continue with Google", color = Color.Black) // Texto negro
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Enlace para registrarse
            TextButton(onClick = { navController.navigate("register") }) {
                Text(text = "¿Eres nuevo? Regístrate aquí")
            }
        }
    }
}


