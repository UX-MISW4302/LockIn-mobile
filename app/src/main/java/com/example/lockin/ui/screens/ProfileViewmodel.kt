package com.example.lockin.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.lockin.viewmodel.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val userPreferences = UserPreferences(application)

    private val _name = MutableStateFlow("Daniel Pedroza")
    private val _email = MutableStateFlow("correo@gmail.com")
    private val _description = MutableStateFlow("Amante del cosplay")

    val name = _name.asStateFlow()
    val email = _email.asStateFlow()
    val description = _description.asStateFlow()

    init {
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            val (savedName, savedEmail, savedDesc) = userPreferences.getUserData()
            _name.value = savedName
            _email.value = savedEmail
            _description.value = savedDesc
        }
    }

    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updateDescription(newDescription: String) {
        _description.value = newDescription
    }

    fun saveData() {
        viewModelScope.launch {
            userPreferences.saveUserData(_name.value, _email.value, _description.value)
        }
    }
}
