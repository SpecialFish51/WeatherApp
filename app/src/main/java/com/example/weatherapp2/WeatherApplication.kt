package com.example.weatherapp2

import android.app.Application
import com.example.weatherapp2.features.settings_screen.di.settingsModule
import com.example.weatherapp2.features.weather_screen.di.appModule
import com.example.weatherapp2.features.wind_screen.di.windModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(listOf<Module>(appModule, windModule, settingsModule))
        }
    }
}