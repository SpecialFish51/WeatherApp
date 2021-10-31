package com.example.weatherapp2.features.weather_screen.data

import com.example.weatherapp2.features.weather_screen.data.api.model.WeatherWindModel
import com.example.weatherapp2.features.weather_screen.data.api.model.WeatherModel
import com.example.weatherapp2.features.weather_screen.domain.model.WeatherDomainModel
import com.example.weatherapp2.features.weather_screen.domain.model.WindDomainModel

fun WeatherModel.toDomain() : WeatherDomainModel {
    return WeatherDomainModel(
        this.main.temp,
        this.main.tempMin,
        this.main.tempMax,
        this.main.humidity,
        this.wind.toDomain()
    )
}

fun WeatherWindModel.toDomain() : WindDomainModel {
    return WindDomainModel(
        this.speed,
        this.degree
    )
}