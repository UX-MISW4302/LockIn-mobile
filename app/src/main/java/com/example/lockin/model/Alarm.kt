package com.example.lockin.model

import java.util.Date

data class Alarm(
    val id: Int,
    val name: String,
    val duration: Long, // Duration in milliseconds
    val beginningDateTime: Date, // Now a Date object
    val endingDateTime: Date // Now a Date object
) {
    fun getRemainingTime(): Long {
        val currentTime = System.currentTimeMillis()
        return (endingDateTime.time - currentTime).coerceAtLeast(0) // Avoid negative values
    }

    fun formatRemainingTime(): String {
        val remaining = getRemainingTime()
        val seconds = (remaining / 1000) % 60
        val minutes = (remaining / (1000 * 60)) % 60
        val hours = (remaining / (1000 * 60 * 60))
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

}