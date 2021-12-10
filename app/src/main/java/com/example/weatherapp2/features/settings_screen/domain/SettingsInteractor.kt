package com.example.weatherapp2.features.settings_screen.domain

import com.example.weatherapp2.features.settings_screen.data.SettingsModel
import com.example.weatherapp2.features.settings_screen.data.SettingsRepo


class SettingsInteractor(private val repository: SettingsRepo) {
    suspend fun saveCity(city: String) {
        repository.saveCity(city)
    }

    suspend fun getSettings(): SettingsModel {
        return repository.getSettings()
    }
}