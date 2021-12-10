package com.example.weatherapp2.features.wind_screen.ui

import com.example.weatherapp2.base.Event
import com.example.weatherapp2.features.weather_screen.domain.model.WindDomainModel


data class ViewState(
    val windDomainModel: WindDomainModel,
    val errorMessage: String
)

sealed class UIEvent(): Event {
    object GetWind: UIEvent()
}

sealed class DataEvent(): Event {
    data class SuccessWindGetting(val windDomainModel: WindDomainModel): DataEvent()
    data class  ErrorWindGetting(val error: String): DataEvent()
}