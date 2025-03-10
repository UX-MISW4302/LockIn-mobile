package com.example.lockin.model

data class Alarm(
    val id: Int,
    val name: String,
    val duration: Long, // Duration in milliseconds
    val beginningDateTime: Long, // Store as Unix timestamp
    val endingDateTime: Long // Store as Unix timestamp
)
