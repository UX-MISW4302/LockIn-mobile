package com.example.lockin.ui.screens

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lockin.model.Task
import com.example.lockin.model.User
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import java.text.SimpleDateFormat
import java.util.Locale


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.lockin.model.Subtask
import com.example.lockin.ui.components.CustomButton


@Composable
fun TaskView(navController: NavController, task: Task) {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))


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
                .padding(horizontal = 32.dp),// Enables scrolling
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Categoría",
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start) // Aligns text to the left
            )



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp) // Set height to match Figma
                    .border(1.dp, Color.Black, RoundedCornerShape(12.dp)) // Border with rounded corners
                    .clip(RoundedCornerShape(12.dp)) // Clipping for rounded edges
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(text = task.category, fontSize = 30.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(6.dp))



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier.weight(1f), // Each column takes equal space
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Fecha de Inicio",
                        fontSize = 24.sp, // Increased size
                        color = Color.Black
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
                        Text(text = dateFormat.format(task.beginningDate), fontSize = 20.sp, color = Color.Black)

                    }
                }

                Column(
                    modifier = Modifier.weight(1f), // Each column takes equal space
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Fecha de Fin",
                        fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.Start)
                                .padding(start = 32.dp)// Forces the text to align to the left
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
                        Text(text = dateFormat.format(task.finishingDate), fontSize = 20.sp,color = Color.Black)

                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

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
                                    colors = listOf(Color(0xFF52BFBA),
                                        Color(0xFF6DA0E4),
                                        Color(0xFF5952E7),
                                        Color(0xFFE551E0),
                                        Color(0xFFC91F22)) // Aquamarine to Neon Purple
                                )
                            )
                    )
                }


                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "${task.progress}%",
                    color = Color.Black
                )
            }


            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(), // Makes the Box take full width
                contentAlignment = Alignment.Center // Centers the button inside
            ) {
                Box(
                    modifier = Modifier
                        .width(180.dp)  // Rectangle width
                        .height(60.dp)  // Rectangle height
                        .clip(RoundedCornerShape(12.dp)) // Slightly rounded corners
                        .background(Color.Black) // Button background
                        .clickable { navController.navigate("createSubtask/1") }, // Click action
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Crear Subtarea",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }




            Spacer(modifier = Modifier.height(6.dp))

            Text(text = "Subtareas",
                fontSize = 22.sp)

            SubtasksContainer(task = task, subtasks = task.subtasks, navController = navController)

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Participantes",
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Button(
                    onClick = { /* Handle add participant action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                    modifier = Modifier
                        .height(30.dp)
                        .width(90.dp)
                ) {
                    Text(text = "Agregar +", color = Color.White, fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(task.participants) { participant ->
                    LoadBitmapImageFromAssets(assetName = participant.photo)
                }
            }
        }


    }
}

@Composable
fun SubtasksContainer(task: Task, subtasks: List<Subtask>, navController: NavController) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Set a fixed height for scrollability
            .border(1.dp, Color.Black)
            .background(Color.White)
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(subtasks) { subtask ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .border(1.dp, Color.Black)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0x8852BFBA), // Lighter teal
                                    Color(0x886DA0E4), // Lighter blue
                                    Color(0x885952E7), // Lighter purple
                                    Color(0x88E551E0), // Lighter pink
                                    Color(0x88C91F22)  // Lighter red
                                )
                                // Pastel Light Blue to Light Red
                            )
                        )
                        .padding(8.dp)
                        .clickable { navController.navigate("SubtaskScreen/${task.id}/${subtask.id}") } // Navigate to subtask screen
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Subtask name aligned to the left
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(text = subtask.name, color = Color.Black)
                        }

                        // Dates centered
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "${dateFormat.format(subtask.beginningDate)}    -    ${dateFormat.format(subtask.finishingDate)}",
                                color = Color.Black
                            )
                        }
                    }
                }


            }
        }
    }



}

@Composable
fun LoadBitmapImageFromAssets(assetName: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val bitmap = remember {
        try {
            val inputStream = context.assets.open(assetName)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            null
        }
    }

    bitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = null,
            modifier = modifier
                .size(80.dp) // Size of the circle
                .clip(CircleShape) // Circular shape
                .border(2.dp, Color.Black, CircleShape) // Black border
        )
    }
}



@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ParticipantsSection(participants: List<User>, onAddClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Row with "Participantes" label and "Agregar +" button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Participantes")

            Button(
                onClick = onAddClick,
                modifier = Modifier
                    .height(36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Agregar +", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Scrollable Row for participant photos
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(participants) { participant ->
                Image(
                    painter = rememberAsyncImagePainter(participant.photo),
                    contentDescription = participant.name,
                    modifier = Modifier
                        .size(50.dp) // Image size
                        .clip(CircleShape) // Makes it circular
                        .border(2.dp, Color.Black, CircleShape) // Black border
                )
            }
        }
    }
}


