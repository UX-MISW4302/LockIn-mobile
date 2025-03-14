package com.example.lockin.ui.screens
import androidx.compose.foundation.background
import com.example.lockin.model.Task

import androidx.compose.ui.window.Dialog

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
import com.example.lockin.model.User

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*
import com.example.lockin.R

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var isEditMode by remember { mutableStateOf(false) }

    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val description by viewModel.description.collectAsState()
    var selectedAchievement by remember { mutableStateOf<Pair<String, Int>?>(null) }

    val achievements = listOf(
        Pair("Esta medalla se consiguio al haber completado 2 tareas de forma correcta\n", R.drawable.oro),
    )

    val gradientColors = listOf(
        Color(0x0C52BFBA),
        Color(0x176DA0E4),
        Color(0x0C5952E7),
        Color(0x11E551E0),
        Color(0x03C91F22)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colors = gradientColors))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Perfil", fontSize = 32.sp, textAlign = TextAlign.Center)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF52BFBA), Color(0xFF6DA0E4), Color(0xFF5952E7), Color(0xFFE551E0), Color(0xFFC91F22))
                    )
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                if (isEditMode) {
                    OutlinedTextField(value = name, onValueChange = { viewModel.updateName(it) }, label = { Text("Nombre") })
                    OutlinedTextField(value = email, onValueChange = { viewModel.updateEmail(it) }, label = { Text("Correo") })
                } else {
                    Text(text = name, style = MaterialTheme.typography.headlineMedium, color = Color.Black)
                    Text(text = email, style = TextStyle(fontSize = 14.sp, color = Color.Gray), textAlign = TextAlign.Center)
                }
            }
            Spacer(Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                .padding(12.dp)
        ) {
            if (isEditMode) {
                OutlinedTextField(
                    value = description,
                    onValueChange = { viewModel.updateDescription(it) },
                    label = { Text("Descripción") },
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Text(text = description, style = TextStyle(fontSize = 14.sp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (isEditMode) {
                viewModel.saveData()
            }
            isEditMode = !isEditMode
        }) {
            Text(if (isEditMode) "Guardar" else "Editar")
        }

        Text(text = "Logros", style = MaterialTheme.typography.headlineSmall, color = Color.Black, modifier = Modifier.padding(top = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(achievements) { achievement ->
                Row(
                    modifier = Modifier
                        .clickable { selectedAchievement = achievement }
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = achievement.second),
                        contentDescription = "Achievement Icon",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }

        if (selectedAchievement != null) {
            AchievementDialog(achievement = selectedAchievement!!) {
                selectedAchievement = null
            }
        }
    }
}

@Composable
fun AchievementDialog(
    achievement: Pair<String, Int>,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Fondo blanco
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x59EAB122)) // 35% de opacidad sobre el fondo blanco
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f)) // Empuja todo hacia arriba

                Image(
                    painter = painterResource(id = R.drawable.oro), // Asegúrate de tener un ícono en res/drawable
                    contentDescription = "Medalla",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = achievement.first,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Conseguida el 21/02/25",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Spacer(modifier = Modifier.weight(1f)) // Esto empuja el botón hacia abajo

                Image(
                    painter = painterResource(id = R.drawable.cross), // Ícono en res/drawable
                    contentDescription = "Cerrar",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally) // Lo mantiene centrado horizontalmente
                        .clickable { onDismiss() }
                )
            }
        }
    }
}
