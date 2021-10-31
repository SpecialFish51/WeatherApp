package com.example.weatherapp2.features.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val humidity: String,
    val windDomainModel: WindDomainModel
)