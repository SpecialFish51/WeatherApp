package com.example.weatherapp2.features.wind_screen.di


import com.example.weatherapp2.features.settings_screen.domain.SettingsInteractor
import com.example.weatherapp2.features.weather_screen.domain.WeatherInteractor
import com.example.weatherapp2.features.wind_screen.ui.WindScreenViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windModule = module {
    viewModel {
        WindScreenViewModel(get<WeatherInteractor>(), get<SettingsInteractor>())
    }
}