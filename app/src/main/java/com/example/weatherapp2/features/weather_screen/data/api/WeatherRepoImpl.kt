package com.example.weatherapp2.features.weather_screen.data.api

import com.example.weatherapp2.features.weather_screen.data.toDomain
import com.example.weatherapp2.features.weather_screen.domain.model.WeatherDomainModel


class WeatherRepoImpl(private val source: WeatherRemoteSource): WeatherRepo {
    override suspend fun getWeather(): WeatherDomainModel {
        return source.getWeather("Moscow").toDomain()
    }
}