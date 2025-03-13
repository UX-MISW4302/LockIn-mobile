package com.example.lockin.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lockin.model.Alarm
import com.example.lockin.model.Subtask
import com.example.lockin.ui.screens.LogInScreen
import com.example.lockin.ui.screens.RegisterScreen
import com.example.lockin.ui.screens.HomeScreen
import com.example.lockin.ui.screens.TaskView
import com.example.lockin.model.Task
import com.example.lockin.model.User
import com.example.lockin.ui.screens.AlarmScreen
import com.example.lockin.ui.screens.CreateSubtaskScreen
import com.example.lockin.ui.screens.SubtaskScreen
import com.example.yourapp.viewmodel.AlarmViewModel
import java.util.Date

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    val alarmViewModel: AlarmViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = "task/1",
        modifier = Modifier.padding(paddingValues) // Ensures screens respect the navbar
    ) {
        composable("login") { LogInScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("task/{taskId}", arguments = listOf(navArgument("taskId") { type = NavType.IntType })) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            val task = mockTasks.find { it.id == taskId } // Find the task by its ID

            if (task != null) {
                TaskView(navController, task)
            }
        }

        composable("createSubtask/{taskId}", arguments = listOf(navArgument("taskId") { type = NavType.IntType })) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            val task = mockSubtasks.find { it.id == taskId } // Find the task by its ID

            if (task != null) {
                CreateSubtaskScreen(navController, task)
            }
        }

        composable(
            "subtaskScreen/{taskId}/{subtaskId}",
            arguments = listOf(
                navArgument("taskId") { type = NavType.IntType },
                navArgument("subtaskId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: return@composable
            val subtaskId = backStackEntry.arguments?.getInt("subtaskId")

            val task = mockTasks.find { it.id == taskId } // Find the task by its ID
            val subtask = subtaskId?.let { id -> mockSubtasks.find { it.id == id } } // Find the subtask by its ID

            if (task != null) {
                if (subtask != null) {
                    SubtaskScreen(navController, task, subtask)
                }
            }
        }

        composable(
            "alarm/{taskId}/{subtaskId}/{alarmId}",
            arguments = listOf(
                navArgument("taskId") { type = NavType.IntType },
                navArgument("subtaskId") { type = NavType.IntType },
                navArgument("alarmId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            val subtaskId = backStackEntry.arguments?.getInt("subtaskId")
            val alarmId = backStackEntry.arguments?.getInt("alarmId")

            // Ensure IDs are non-null
            if (taskId == null || subtaskId == null || alarmId == null) {
                Text(text = "Error: Missing parameters", fontSize = 18.sp, color = Color.Red)
                return@composable
            }

            // Find the objects using IDs
            val task = mockTasks.find { it.id == taskId }
            val subtask = mockSubtasks.find { it.id == subtaskId }
            val alarm = getMockAlarms().firstOrNull() // Fetches the first mock alarm

            // Display the screen if all objects are found, otherwise show an error message
            if (task != null && subtask != null && alarm != null) {
                AlarmScreen(navController, task, subtask, alarm)
            } else {
                Text(text = "Error: Data not found", fontSize = 18.sp, color = Color.Red)
            }
        }



    }
}



fun getMockAlarms(): List<Alarm> {
    val now = System.currentTimeMillis()
    return listOf(
        Alarm(
            id = 1,
            name = "Lock In alarm",
            duration = 120 * 60 * 1000, // 10 minutes
            beginningDateTime = Date(now),
            endingDateTime = Date(now + 120 * 60 * 1000) // 120 minutes from now
        )
    )
}


val mockSubtasks = listOf(
    Subtask(id = 1, name = "Write Report",
        beginningDate = Date(1733070000000), finishingDate = Date(1733156400000),
        estimatedTime = 120, timeConsumed = 60, alarms = emptyList() // 2 hours, 1 hour
    ),
    Subtask(id = 2, name = "Review Code",
        beginningDate = Date(1733156400000), finishingDate = Date(1733242800000),
        estimatedTime = 180, timeConsumed = 90, alarms = emptyList() // 3 hours, 1.5 hours
    ),
    Subtask(id = 3, name = "Design UI",
        beginningDate = Date(1733329200000), finishingDate = Date(1733415600000),
        estimatedTime = 90, timeConsumed = 45, alarms = emptyList() // 1.5 hours, 45 minutes
    ),
    Subtask(id = 4, name = "Market Research",
        beginningDate = Date(1733502000000), finishingDate = Date(1733588400000),
        estimatedTime = 150, timeConsumed = 120, alarms = emptyList() // 2.5 hours, 2 hours
    ),
    Subtask(id = 5, name = "Workout Plan",
        beginningDate = Date(1733674800000), finishingDate = Date(1733761200000),
        estimatedTime = 60, timeConsumed = 30, alarms = emptyList() // 1 hour, 30 minutes
    )
)

val mockUsers = listOf(
    User(
        name = "Alice Johnson",
        photo = "p1.jpeg",
        email = "alice@example.com",
        description = "Software Engineer with a passion for AI and automation.",
        achievements = listOf("Completed 50 tasks", "Top contributor of the month", "5-star rating from peers")
    ),
    User(
        name = "Bob Smith",
        photo = "p2.jpeg",
        email = "bob@example.com",
        description = "Freelance designer and creative thinker.",
        achievements = listOf("Designed 100+ UI screens", "Won Hackathon 2024", "Published design tutorial")
    ),
    User(
        name = "Charlie Davis",
        photo = "p3.jpeg",
        email = "charlie@example.com",
        description = "Project Manager with experience in agile workflows.",
        achievements = listOf("Managed 10+ successful projects", "Scrum Master Certified", "Trained 50+ team members")
    ),
    User(
        name = "Diana Perez",
        photo = "p4.jpeg",
        email = "diana@example.com",
        description = "Data scientist who loves crunching numbers and extracting insights.",
        achievements = listOf("Developed a machine learning model", "Published research on AI", "Data-driven decision maker")
    ),
    User(
        name = "Ethan Reed",
        photo = "p5.jpeg",
        email = "ethan@example.com",
        description = "Cybersecurity expert and ethical hacker.",
        achievements = listOf("Discovered 10+ security vulnerabilities", "Certified Ethical Hacker", "Worked on Fortune 500 security projects")
    )
)


val mockTasks = listOf(
    Task(
        id = 1, name = "Project Alpha", category = "Work",
        beginningDate = Date(1733070000000), finishingDate = Date(1735675600000),
        progress = 50, subtasks = mockSubtasks, participants = mockUsers
    ),
    Task(
        id = 2, name = "Study AI", category = "Personal",
        beginningDate = Date(1735752000000), finishingDate = Date(1738344000000),
        progress = 30, subtasks = mockSubtasks, participants = emptyList()
    ),
    Task(
        id = 3, name = "Develop App", category = "Technology",
        beginningDate = Date(1738430400000), finishingDate = Date(1741022400000),
        progress = 75, subtasks = mockSubtasks, participants = emptyList()
    ),
    Task(
        id = 4, name = "Fitness Plan", category = "Health",
        beginningDate = Date(1741108800000), finishingDate = Date(1743700800000),
        progress = 20, subtasks = mockSubtasks, participants = emptyList()
    ),
    Task(
        id = 5, name = "Vacation Planning", category = "Travel",
        beginningDate = Date(1743787200000), finishingDate = Date(1746379200000),
        progress = 10, subtasks = mockSubtasks, participants = emptyList()
    )
)



