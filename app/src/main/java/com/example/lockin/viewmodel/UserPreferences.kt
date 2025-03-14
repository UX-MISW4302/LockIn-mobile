package com.example.lockin.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        private val NAME_KEY = stringPreferencesKey("user_name")
        private val EMAIL_KEY = stringPreferencesKey("user_email")
        private val DESCRIPTION_KEY = stringPreferencesKey("user_description")
    }

    suspend fun saveUserData(name: String, email: String, description: String) {
        context.dataStore.edit { prefs ->
            prefs[NAME_KEY] = name
            prefs[EMAIL_KEY] = email
            prefs[DESCRIPTION_KEY] = description
        }
    }

    suspend fun getUserData(): Triple<String, String, String> {
        val prefs = context.dataStore.data.first()
        val name = prefs[NAME_KEY] ?: "Daniel Pedroza"
        val email = prefs[EMAIL_KEY] ?: "correo@gmail.com"
        val description = prefs[DESCRIPTION_KEY] ?: "Amante del cosplay"
        return Triple(name, email, description)
    }
}
