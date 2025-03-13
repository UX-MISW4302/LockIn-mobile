package com.example.lockin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
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
                val backStackEntry by navController.currentBackStackEntryAsState()

                // Extract current route safely
                val currentRoute: String? = backStackEntry?.destination?.route

                // Hide navbar on specific screens
                val hideBottomNavScreens = setOf("alarm", "login", "register") // Base route name(s)

// Check if the current route starts with any of the hidden routes
                val showBottomNav = hideBottomNavScreens.none { currentRoute?.startsWith(it) == true } // Add more if needed
                
                Scaffold(
                    bottomBar = {
                        if (showBottomNav) BottomNavBar(navController)
                    }
                ) { paddingValues ->
                    Surface(modifier = Modifier.fillMaxSize()) {
                        AppNavHost(navController = navController, paddingValues)
                    }
                }
            }
        }
    }
}
