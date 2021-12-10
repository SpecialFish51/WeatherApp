package com.example.weatherapp2.features.settings_screen.data

import kotlinx.coroutines.flow.Flow

interface SettingsStorage {
    val settingsPreferences: Flow<SettingsModel>
    suspend fun saveCity(city: String)
    suspend fun getSettings(): SettingsModel
}