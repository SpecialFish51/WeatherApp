package com.example.weatherapp2.features.weather_screen.domain

import com.example.weatherapp2.base.attempt
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepo


class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(cityName: String) = attempt { repository.getWeather(cityName) }
}