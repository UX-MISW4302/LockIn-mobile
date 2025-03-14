package com.example.lockin.ui.screens

import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.clickable

import com.example.lockin.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.border

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
@Composable
fun FriendProfileScreen(navController: NavController) {
    var selectedAchievement by remember { mutableStateOf<Pair<String, Int>?>(null) }

    val name = "Santiago Sinisterra"
    val email = "santiago.sinisterra@example.com"
    val description = "Apasionado por la tecnología y el deporte. Siempre en busca de nuevos retos."

    val achievements = listOf(
        Pair("Esta medalla se consiguió al haber completado 5 tareas de forma correcta", R.drawable.platino)
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
                Text(text = name, style = MaterialTheme.typography.headlineMedium, color = Color.Black)
                Text(text = email, style = TextStyle(fontSize = 14.sp, color = Color.Gray), textAlign = TextAlign.Center)
            }
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
            Text(text = description, style = TextStyle(fontSize = 14.sp))
        }

        Spacer(modifier = Modifier.height(16.dp))

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
            AchievementsDialog(achievement = selectedAchievement!!) {
                selectedAchievement = null
            }
        }
    }
}

@Composable
fun AchievementsDialog(
    achievement: Pair<String, Int>,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.platino),
                    contentDescription = "Medalla",
                    modifier = Modifier
                        .size(400.dp)
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

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = "Cerrar",
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable { onDismiss() }
                )
            }
        }
    }
}

