package com.example.lockin.model

import java.util.Date

data class Subtask(
    val id: Int,
    val name: String,
    val beginningDate: Date, // Now a Date object
    val finishingDate: Date, // Now a Date object
    val estimatedTime: Long, // Store in milliseconds
    val timeConsumed: Long, // Store in milliseconds
    val alarms: List<Alarm> = emptyList()
)