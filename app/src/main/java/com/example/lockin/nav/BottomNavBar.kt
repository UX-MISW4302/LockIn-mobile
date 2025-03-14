package com.yourapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lockin.R

@Composable
fun BottomNavBar(navController: NavController) {
    Column {
        // Gradient Line
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
                        ) // Gradient from left to right
                    )
                )
        )

        // Bottom Navigation
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            val items = listOf(
                "home" to R.drawable.home,
                "friends" to R.drawable.friends,
                "addTask" to R.drawable.add,
                "profile" to R.drawable.user,
                "settings" to R.drawable.setting
            )

            items.forEach { (screen, icon) ->
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id = icon), contentDescription = screen) },
                    selected = false, // Handle selection logic
                    onClick = { navController.navigate(screen) {
                        launchSingleTop = true
                    } }
                )
            }
        }
    }
}




data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)