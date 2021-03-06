package com.example.weatherapp2.features.settings_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp2.features.settings_screen.data.SettingsModel
import com.example.weatherapp2.features.settings_screen.domain.SettingsInteractor
import kotlinx.coroutines.launch

class SettingsScreenViewModel(
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {
    val liveData: MutableLiveData<SettingsModel> = MutableLiveData()

    fun getSettings() {
        viewModelScope.launch {
            liveData.postValue(settingsInteractor.getSettings())
        }
    }

    fun saveCity(city: String) {
        viewModelScope.launch {
            settingsInteractor.saveCity(city)
        }
    }
}