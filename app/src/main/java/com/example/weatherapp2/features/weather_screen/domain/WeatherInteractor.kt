package com.example.weatherapp2.features.weather_screen.domain

import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepo
import com.example.weatherapp2.features.weather_screen.domain.model.WeatherDomainModel

class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(): WeatherDomainModel {
        return repository.getWeather()
    }
}