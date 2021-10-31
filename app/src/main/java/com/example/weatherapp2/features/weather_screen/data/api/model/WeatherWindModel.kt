package com.example.weatherapp2.features.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val degree: Int
)