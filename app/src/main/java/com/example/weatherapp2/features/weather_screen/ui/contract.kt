package com.example.weatherapp2.features.weather_screen.ui

import com.example.weatherapp2.base.Event
import com.example.weatherapp2.features.weather_screen.domain.model.WeatherDomainModel


data class ViewState(
    val weatherModel: WeatherDomainModel,
    val cityName: String,
    val isLoading: Boolean,
    val error: String?
)

sealed class UIEvent() : Event {
    object RequestWeather: UIEvent()
}

sealed class DataEvent() : Event {
    data class SuccessWeatherRequest(
        val cityName: String,
        val weatherModel: WeatherDomainModel
    ) : DataEvent()

    data class ErrorWeatherRequest(val error: String) : DataEvent()
}