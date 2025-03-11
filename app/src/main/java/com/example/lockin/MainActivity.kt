package com.example.lockin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lockin.ui.theme.LockInTheme
import com.example.lockin.nav.AppNavHost
import com.yourapp.ui.navigation.BottomNavBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LockInTheme {
                val navController = rememberNavController()

                // 🔥 Scaffold to handle layout and prevent overlap
                Scaffold(
                    bottomBar = { BottomNavBar(navController) } // Adds the bottom nav bar
                ) { paddingValues ->
                    // 🔥 Pass paddingValues to AppNavHost so content doesn't overlap
                    Surface(modifier = Modifier.fillMaxSize()) {
                        AppNavHost(navController = navController, paddingValues)
                    }
                }
            }
        }
    }
}
