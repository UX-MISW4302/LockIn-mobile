package com.example.lockin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lockin.model.Task
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import com.example.lockin.ui.components.CustomButton


@Composable
fun TaskView(navController: NavController, task: Task) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = task.name,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(10.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp) // Thickness of the line
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF7FFFD4),
                            Color(0xFF8A2BE2)
                        ) // Aquamarine to Violet
                    )
                )
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Categoría",
                fontSize = 22.sp)



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black)
                    .background(Color.White)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = task.category, fontSize = 30.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier.weight(1f), // Each column takes equal space
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Fecha de Inicio")
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .border(1.dp, Color.Black)
                            .background(Color.White)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = task.beginningDate, color = Color.Black)
                    }
                }

                Column(
                    modifier = Modifier.weight(1f), // Each column takes equal space
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Fecha de Fin",
                        modifier = Modifier.align(Alignment.Start)
                                .padding(start = 32.dp)// Forces the text to align to the left
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Adjust the box width inside the column
                            .border(1.dp, Color.Black)
                            .background(Color.White)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = task.finishingDate, color = Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Progreso",
                fontSize = 22.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f) // Makes the progress bar take available space
                        .height(12.dp) // Increased height for better visibility
                        .border(1.dp, Color.Black, RoundedCornerShape(6.dp)) // Adds black border with rounded corners
                        .clip(RoundedCornerShape(6.dp)) // Ensures both layers have rounded edges
                        .background(Color.White) // White background for the empty space
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(task.progress / 100f) // Fills based on progress
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(6.dp)) // Ensures rounded edges for progress
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF7FFFD4), Color(0xFF8A2BE2)) // Aquamarine to Neon Purple
                                )
                            )
                    )
                }


                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "${task.progress}%",
                    color = Color.Black
                )
            }
        }
        CustomButton(
            text = "Crear Subtarea",
            onClick = { /* Handle subtask creation */ },
            backgroundColor = Color.Black,
            textColor = Color.White
        )

    }
}