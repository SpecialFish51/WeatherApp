package com.example.weatherapp2.features.settings_screen.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.weatherapp2.features.settings_screen.data.SettingsModel
import kotlinx.coroutines.flow.*
import java.io.IOException

class SettingsStorageImpl(
    private val context: Context
) : SettingsStorage {
    companion object {
        private const val CITY_PREFERENCES = "cityPreferences"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = CITY_PREFERENCES)
    }


    override val settingsPreferences: Flow<SettingsModel> = context.dataStore.data
        .catch {
            // throws an IOException when an error is encountered when reading data
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        // Get our show completed value, defaulting to "Moscow" if not set:
        .map { preferences ->
            SettingsModel(
                city = preferences[SettingsScheme.city] ?: "Moscow"
            )
        }
        .distinctUntilChanged()

    override suspend fun saveCity(city: String) {
        context.dataStore.edit {
            it[SettingsScheme.city] = city
        }
    }

    override suspend fun getSettings(): SettingsModel {
        return context.dataStore.data.map {
            SettingsModel (
                city = it[SettingsScheme.city] ?: "Moscow"
            )
        }.first()
    }
}