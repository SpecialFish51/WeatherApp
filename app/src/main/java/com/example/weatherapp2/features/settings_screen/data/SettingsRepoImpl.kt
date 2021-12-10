package com.example.weatherapp2.features.settings_screen.data

class SettingsRepoImpl(private val dataStorage: SettingsStorage): SettingsRepo {
    override suspend fun saveCity(city: String) {
        dataStorage.saveCity(city)
    }

    override suspend fun getSettings(): SettingsModel {
        return dataStorage.getSettings()
    }
}