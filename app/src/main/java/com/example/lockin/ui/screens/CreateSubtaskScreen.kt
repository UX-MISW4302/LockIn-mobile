package com.example.lockin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lockin.model.Subtask
import com.example.lockin.model.Task

@Composable
fun CreateSubtaskScreen(navController: NavController, subtask: Subtask) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = subtask.name)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Go Back to Home")
        }
        Button(onClick = { navController.navigate("task/1") }) {
            Text(text = "A task")
        }
    }
}