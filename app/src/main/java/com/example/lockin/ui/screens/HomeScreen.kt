package com.example.lockin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla vacia de Home")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Go Back to Home")
        }
        Button(onClick = { navController.navigate("task/1") }) {
            Text(text = "A task")
        }
    }
}