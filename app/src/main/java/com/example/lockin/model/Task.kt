package com.example.lockin.model

import java.io.Serializable
import java.util.Date

data class Task(
    val id: Int,
    val name: String,
    val category: String,
    val beginningDate: Date, // Now a Date object
    val finishingDate: Date, // Now a Date object
    val progress: Int, // Percentage (0-100)
    val subtasks: List<Subtask> = emptyList(),
    val participants: List<User> // Now a list of participant identifiers (email, username, etc.)
) : Serializable
