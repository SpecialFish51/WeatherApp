package com.example.weatherapp2.features.settings_screen.data

interface SettingsRepo {
    suspend fun saveCity(city: String)
    suspend fun getSettings(): SettingsModel
}