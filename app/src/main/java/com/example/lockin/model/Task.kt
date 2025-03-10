package com.example.lockin.model

data class Task(
    val id: Int,
    val name: String,
    val category: String,
    val beginningDate: String, // Store as Unix timestamp (milliseconds)
    val finishingDate: String, // Store as Unix timestamp (milliseconds)
    val progress: Int, // Percentage (0-100)
    val subtasks: List<Subtask> = emptyList(),
    val participant: String // Can be an email, username, etc.
)
