package com.example.lockin.ui.screens

import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lockin.model.Alarm
import com.example.lockin.model.Subtask
import com.example.lockin.model.Task
import com.example.yourapp.viewmodel.AlarmViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.lockin.R

import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*


@Composable
fun SubtaskScreen(navController: NavController, task: Task, subtask: Subtask) {
    //val alarmViewModel: AlarmViewModel = viewModel(navController.currentBackStackEntry?.viewModelStoreOwner!!)
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    var timeInput by remember { mutableStateOf("") }
    var alarmName by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = task.name,
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = subtask.name,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Fecha de Inicio", fontSize = 18.sp)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .height(52.dp) // Set height to match Figma
                            .border(1.dp, Color.Black, RoundedCornerShape(12.dp)) // Border with rounded corners
                            .clip(RoundedCornerShape(12.dp)) // Clipping for rounded edges
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = dateFormat.format(subtask.beginningDate), fontSize = 22.sp, color = Color.Black)
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Fecha de Fin",
                        modifier = Modifier.align(Alignment.Start)
                            .padding(start = 32.dp),
                            fontSize = 18.sp
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .height(52.dp) // Set height to match Figma
                            .border(1.dp, Color.Black, RoundedCornerShape(12.dp)) // Border with rounded corners
                            .clip(RoundedCornerShape(12.dp)) // Clipping for rounded edges
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = dateFormat.format(subtask.finishingDate), fontSize = 22.sp, color = Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Tiempo Estimado", fontSize = 18.sp)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .height(52.dp) // Set height to match Figma
                            .border(1.dp, Color.Black, RoundedCornerShape(12.dp)) // Border with rounded corners
                            .clip(RoundedCornerShape(12.dp)) // Clipping for rounded edges
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.time), // Load custom drawable
                                contentDescription = "Clock",
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = formatTime(subtask.estimatedTime),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Tiempo Utilizado",
                        modifier = Modifier.align(Alignment.Start)
                            .padding(start = 32.dp),
                        fontSize = 18.sp
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .height(52.dp) // Set height to match Figma
                            .border(1.dp, Color.Black, RoundedCornerShape(12.dp)) // Border with rounded corners
                            .clip(RoundedCornerShape(12.dp)) // Clipping for rounded edges
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.time), // Load custom drawable
                                contentDescription = "Clock",
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = formatTime(subtask.timeConsumed),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF)),
                    modifier = Modifier
                        .width(160.dp) // Set width to 160dp
                ) {
                    Text(text = "Completar", color = Color.Black, fontSize = 18.sp)
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                    modifier = Modifier
                        .width(160.dp)
                ) {
                    Text(text = "Eliminar", color = Color.Black, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0x886DA0E4), Color(0x885952E7))
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = alarmName,
                        onValueChange = { alarmName = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        ),
                        textStyle = TextStyle(color = Color.Gray),
                    )

                    Spacer(modifier = Modifier.height(12.dp)) // Adds space between fields

                    OutlinedTextField(
                        value = timeInput,
                        onValueChange = { timeInput = it },
                        label = { Text("Duración (HH:MM)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val timePicker = TimePickerDialog(
                                    context,
                                    { _, hourOfDay, minute ->
                                        timeInput = String.format("%02d:%02d", hourOfDay, minute)
                                    },
                                    calendar.get(Calendar.HOUR_OF_DAY),
                                    calendar.get(Calendar.MINUTE),
                                    true
                                )
                                timePicker.show()
                            }
                            ,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        ),
                        textStyle = TextStyle(color = Color.Gray),
                        readOnly = true
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        modifier = Modifier
                            .width(160.dp),
                        onClick = {
                            val currentTime = Date()
                            val timeParts = timeInput.split(":")
                            val hours = timeParts.getOrNull(0)?.toIntOrNull() ?: 0
                            val minutes = timeParts.getOrNull(1)?.toIntOrNull() ?: 0
                            val durationMillis = (hours * 60 + minutes) * 60 * 1000L

                            val endingTime = Calendar.getInstance().apply {
                                time = currentTime
                                add(Calendar.MILLISECOND, durationMillis.toInt())
                            }.time

                            val newAlarm = Alarm(
                                id = (0..10000).random(),
                                name = alarmName,
                                duration = durationMillis,
                                beginningDateTime = currentTime,
                                endingDateTime = endingTime
                            )

                            //alarmViewModel.addAlarm(newAlarm)

                            //Log.d("AlarmDebug", "Alarms List: ${alarmViewModel.alarms}")

                            navController.navigate("alarm/${task.id}/${subtask.id}/1")
                            //navController.navigate(("home"))
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text(text = "Crear alarma", color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}

fun formatTime(minutes: Long?): String {
    if (minutes == null) return "--:--"
    val hours = minutes / 60
    val mins = minutes % 60
    return "%02d:%02d".format(hours, mins)
}
