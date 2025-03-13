package com.example.lockin.ui.screens
import com.example.lockin.model.Task

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen(navController: NavController) {
    val sampleTasks = listOf(
        Task(1, "Procesos de desarrollo ágil", "Software", Date(2024, 2, 21), Date(2024, 2, 24), 20, emptyList(), emptyList()),
        Task(2, "Diseño UX/UI", "Diseño", Date(2024, 3, 1), Date(2024, 3, 5), 50, emptyList(), emptyList()),
        Task(3, "Modelado de datos", "Bases de Datos", Date(2024, 4, 10), Date(2024, 4, 15), 80, emptyList(), emptyList())
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Tareas",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(sampleTasks) { task ->
                TaskCard(task, navController)
            }
        }
    }
}

@Composable
fun TaskCard(task: Task, navController: NavController) {
    val dateFormatter = SimpleDateFormat("dd/MM", Locale.getDefault())

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate("task/${task.id}") },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = task.name, fontSize = 18.sp)
                Text(text = "${dateFormatter.format(task.beginningDate)} - ${dateFormatter.format(task.finishingDate)}", fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { task.progress / 100f },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFBB86FC) // Morado claro
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${task.progress}%", fontSize = 14.sp)
        }
    }
}