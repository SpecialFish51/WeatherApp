package com.example.weatherapp2.features.settings_screen.di


import com.example.weatherapp2.features.settings_screen.data.SettingsRepo
import com.example.weatherapp2.features.settings_screen.data.SettingsRepoImpl
import com.example.weatherapp2.features.settings_screen.data.SettingsStorage
import com.example.weatherapp2.features.settings_screen.data.SettingsStorageImpl
import com.example.weatherapp2.features.settings_screen.domain.SettingsInteractor
import com.example.weatherapp2.features.settings_screen.ui.SettingsScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {
    single<SettingsStorage> {
        SettingsStorageImpl(androidContext())
    }

    single<SettingsRepo> {
        SettingsRepoImpl(get<SettingsStorage>())
    }

    single<SettingsInteractor> {
        SettingsInteractor(get<SettingsRepo>())
    }

    viewModel{
        SettingsScreenViewModel(get<SettingsInteractor>())
    }
}