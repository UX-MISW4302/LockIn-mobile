package com.example.lockin.ui.screens

import java.util.Date
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lockin.model.Alarm
import com.example.lockin.model.Subtask
import com.example.lockin.model.Task
import java.text.SimpleDateFormat
import java.util.Locale
@Composable
fun AlarmScreen(navController: NavController, task: Task, subtask: Subtask, alarm: Alarm) {
    val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Alarm Details", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(10.dp))

        // Line separator
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

        Spacer(modifier = Modifier.height(16.dp))

        // Display task, subtask, and alarm details
        Text(text = "Task: ${task.name}", fontSize = 22.sp)
        Text(text = "Subtask: ${subtask.name}", fontSize = 20.sp)
        Text(text = "Alarm: ${alarm.name}", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Start: ${dateTimeFormat.format(alarm.beginningDateTime)}", fontSize = 16.sp)
        Text(text = "End: ${dateTimeFormat.format(alarm.endingDateTime)}", fontSize = 16.sp)
    }
}
