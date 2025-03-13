package com.example.lockin.ui.screens

import java.util.Date
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lockin.model.Alarm
import com.example.lockin.model.Subtask
import com.example.lockin.model.Task
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
@Composable
fun AlarmScreen(navController: NavController, task: Task, subtask: Subtask, alarm: Alarm) {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxSize(), // Add padding for spacing
        horizontalAlignment = Alignment.Start // Ensures all content aligns to the left
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lock In",
            fontSize = 32.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) // Adds slight padding on both sides
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = task.name, fontSize = 48.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = subtask.name, fontSize = 28.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = alarm.name, fontSize = 28.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Adds some spacing on both sides
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Inicio", fontSize = 18.sp)
                    Text(text = "Fin", fontSize = 18.sp)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f) // Makes the progress bar take available space
                            .height(12.dp) // Increased height for better visibility
                            .border(
                                1.dp,
                                Color.Black,
                                RoundedCornerShape(6.dp)
                            ) // Adds black border with rounded corners
                            .clip(RoundedCornerShape(6.dp)) // Ensures both layers have rounded edges
                            .background(Color.White) // White background for the empty space
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f) // Fills based on progress
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(6.dp)) // Ensures rounded edges for progress
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFF0A7ED9),  // Full color
                                            Color(0xFF0A7ED9).copy(alpha = 0.5f), // Semi-transparent
                                            Color.Transparent  // Fully faded out
                                        )
                                    )
                                )
                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = timeFormat.format(alarm.beginningDateTime), fontSize = 18.sp)
                    Text(text = timeFormat.format(alarm.endingDateTime), fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Adds some spacing on both sides
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Último descanso", fontSize = 18.sp)
                    Text(text = "Siguiente descanso", fontSize = 18.sp)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f) // Makes the progress bar take available space
                            .height(12.dp) // Increased height for better visibility
                            .border(
                                1.dp,
                                Color.Black,
                                RoundedCornerShape(6.dp)
                            ) // Adds black border with rounded corners
                            .clip(RoundedCornerShape(6.dp)) // Ensures both layers have rounded edges
                            .background(Color.White) // White background for the empty space
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f) // Fills based on progress
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(6.dp)) // Ensures rounded edges for progress
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFF5952E7),  // Full color
                                            Color(0xFF5952E7).copy(alpha = 0.5f), // Semi-transparent
                                            Color.Transparent  // Fully faded out
                                        )
                                    )
                                )
                        )
                    }
                }

                val calendar = Calendar.getInstance().apply {
                    time = alarm.beginningDateTime
                    add(Calendar.MINUTE, 30)
                }
                val adjustedEndTime = calendar.time

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = timeFormat.format(alarm.beginningDateTime), fontSize = 18.sp)
                    Text(text = timeFormat.format(adjustedEndTime), fontSize = 18.sp)
                }

            }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFB5EAEA), // Light Aqua
                            Color(0xFFC6DCE4), // Soft Blue
                            Color(0xFFD9E4F5), // Light Purple
                            Color(0xFFEFD9F5)  // Soft Pink
                        )
                    ),
                    ),

            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Tiempo restante",
                    fontSize = 36.sp,
                    color = Color.Black
                )

                // Convert duration (milliseconds) to hours & minutes
                val totalSeconds = (alarm.duration / 1000).toInt()
                val hours = totalSeconds / 3600
                val minutes = (totalSeconds % 3600) / 60
                val seconds = totalSeconds % 60

                Text(
                    text = String.format("%02d:%02d:%02d", hours, minutes, seconds),
                    fontSize = 56.sp,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.navigate("home")},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Rendirse", color = Color.White, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(46.dp))
    }
}
