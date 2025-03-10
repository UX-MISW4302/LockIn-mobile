package com.example.lockin.model

data class Subtask(
    val id: Int,
    val name: String,
    val beginningDate: Long,
    val finishingDate: Long,
    val estimatedTime: Long, // Store in milliseconds
    val timeConsumed: Long, // Store in milliseconds
    val alarms: List<Alarm> = emptyList()
)
