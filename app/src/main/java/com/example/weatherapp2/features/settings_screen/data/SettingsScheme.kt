package com.example.weatherapp2.features.settings_screen.data

import androidx.datastore.preferences.core.stringPreferencesKey

object SettingsScheme {
    val city = stringPreferencesKey("cityName")
}