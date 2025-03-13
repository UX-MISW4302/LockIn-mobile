package com.example.lockin.ui.screens
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen(navController: NavController) {
    val sampleTasks = listOf(
        Task(1, "Project Alpha", "Software", Date(2024, 2, 12), Date(2024, 12, 31), 50, emptyList(), emptyList()),
        Task(2, "Study AI", "Diseño", Date(2024, 1, 1), Date(2024, 1, 31), 30, emptyList(), emptyList()),
        Task(3, "Develop App", "Bases de Datos", Date(2024, 1, 2), Date(2024, 3, 3), 75, emptyList(), emptyList())
    )

    val gradientColors = listOf(
        Color(0x0C52BFBA), // 3% Opacidad
        Color(0x176DA0E4), // 9% Opacidad
        Color(0x0C5952E7), // 3% Opacidad
        Color(0x11E551E0), // 7% Opacidad
        Color(0x03C91F22)  // 1% Opacidad
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tareas",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(10.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp) // Thickness of the line
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF52BFBA),
                            Color(0xFF6DA0E4),
                            Color(0xFF5952E7),
                            Color(0xFFE551E0),
                            Color(0xFFC91F22)
                        ) // Aquamarine to Violet
                    )
                )
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