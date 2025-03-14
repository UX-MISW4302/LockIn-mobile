package com.example.lockin.ui.screens

import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.shape.RoundedCornerShape

import com.example.lockin.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController

@Composable
fun SolicitudesEnviadasScreen(navController: NavController) {

    val gradientColors = listOf(
        Color(0x0C52BFBA),
        Color(0x176DA0E4),
        Color(0x0C5952E7),
        Color(0x11E551E0),
        Color(0x03C91F22)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colors = gradientColors))
            .padding(bottom = 56.dp) // Espacio para la barra de navegación
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween, // Distribuye los elementos
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // Espaciado superior

            Text(text = "amigos", fontSize = 32.sp, textAlign = TextAlign.Center)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xFF52BFBA), Color(0xFF6DA0E4), Color(0xFF5952E7), Color(0xFFE551E0), Color(0xFFC91F22))
                        )
                    )
            )

            // Encabezado
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Número de amigos", fontSize = 16.sp, color = Color.Black)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "01/99", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = { /* Acción para agregar amigos */ }) {
                                Icon(Icons.Default.Add, contentDescription = "Agregar amigo")
                            }
                        }
                    }
                }
            }

            // Mensaje centrado
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f), // Permite que el Box ocupe todo el espacio restante
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No hay solicitudes de amistad enviadas", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }

        // Barra de navegación inferior
        BottomNavigation(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            backgroundColor = Color.White,
            elevation = 8.dp
        ) {
            BottomNavigationItem(
                selected = false,
                onClick = {navController.navigate("friends")},
                icon = { Icon(Icons.Default.Send, contentDescription = "Solicitudes enviadas") },
                label = { Text("Solicitudes enviadas") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /* Acción Aprobar */ },
                icon = { Icon(Icons.Default.Check, contentDescription = "Aprobar") },
                label = { Text("Aprobar") }
            )
        }
    }
}
