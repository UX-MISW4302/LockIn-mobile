package com.example.lockin.ui.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lockin.model.Task
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CreateSubtaskScreen(navController: NavController, task: Task) {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    var nombre by remember { mutableStateOf(task.name ?: "") }
    var categoria by remember { mutableStateOf(task.category ?: "") }
    var fechaInicio by remember { mutableStateOf("Seleccionar fecha") }
    var fechaFin by remember { mutableStateOf("Seleccionar fecha") }

    val calendar = Calendar.getInstance()

    fun showDatePicker(onDateSelected: (String) -> Unit) {
        DatePickerDialog(
            navController.context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, day)
                onDateSelected(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Screen Title
        Text(
            text = "Nueva SubTarea",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Gradient Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF52BFBA),
                            Color(0xFF6DA0E4),
                            Color(0xFF5952E7),
                            Color(0xFFE551E0),
                            Color(0xFFC91F22)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally // Centers content
            ) {
                Text(
                    text = nombre,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = categoria,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Nombre
            Text(text = "Nombre *", fontSize = 18.sp)
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Categoría
            Text(text = "Categoría", fontSize = 18.sp)
            OutlinedTextField(
                value = categoria,
                onValueChange = { categoria = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Fecha de Inicio (Clickable for DatePicker)
            Text(text = "Fecha de Inicio", fontSize = 18.sp)
            OutlinedTextField(
                value = fechaInicio,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDatePicker { fechaInicio = it } }, // Open date picker on click
                enabled = false
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Fecha de Fin (Clickable for DatePicker)
            Text(text = "Fecha de fin", fontSize = 18.sp)
            OutlinedTextField(
                value = fechaFin,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDatePicker { fechaFin = it } }, // Open date picker on click
                enabled = false
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Crear Button
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Black)
                        .clickable { navController.navigate("Home") },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Crear",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
