package com.example.weatherapp2.features.weather_screen.data.api

import com.example.weatherapp2.features.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {
    suspend fun getWeather(cityName: String): WeatherDomainModel
}