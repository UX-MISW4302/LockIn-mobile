package com.example.lockin.model

data class User(
    val name: String,
    val photo: String, // URL or resource reference
    val email: String,
    val description: String,
    val achievements: List<String>
)