package com.example.lockin.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lockin.ui.screens.LogInScreen
import com.example.lockin.ui.screens.RegisterScreen
import com.example.lockin.ui.screens.HomeScreen
import com.example.lockin.ui.screens.TaskView
import com.example.lockin.model.Task
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("login") { LogInScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("task/1") {
            //val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            val task = mockTasks.first()
            TaskView(navController, task)
        }
    }
}

// Mock data for testing
val mockTasks = listOf(
    Task(id = 1, name = "Project Alpha", category = "Work", beginningDate = "2025-03-01",
        finishingDate = "2025-03-10", progress = 50, subtasks = emptyList(), participant = "user1,user2"),
    Task(id = 2, name = "Study AI", category = "Personal", beginningDate = "2025-03-05",
        finishingDate = "2025-03-20", progress = 30, subtasks = emptyList(), participant = "user3,user4")
)
