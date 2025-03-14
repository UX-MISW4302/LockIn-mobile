package com.example.lockin.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lockin.R

@Composable
fun GiveUpScreen(navController: NavController) {
    var pressCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Lock In",
            fontSize = 32.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Gradient Divider
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

        Spacer(modifier = Modifier.height(32.dp))

        // Big Text
        Text(
            text = "Grita 3 veces para rendirte",
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Load Logo Image
        Image(
            painter = painterResource(id = R.drawable.locky),
            contentDescription = "App Logo",
            modifier = Modifier.size(240.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // X Symbols (Turn into ✓ when button is pressed)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                Text(
                    text = if (index < pressCount) "✔" else "❌",
                    fontSize = 48.sp,
                    color = if (index < pressCount) Color.Green else Color.Red,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // "Rendirse" Button
        Button(
            onClick = {
                if (pressCount < 3) {
                    pressCount++
                    if (pressCount == 3) {
                        navController.navigate("Home") // Navigate when pressed 3 times
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .width(200.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Text(
                text = "Rendirse",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
