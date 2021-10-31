package com.example.weatherapp.features.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainModel(
    @SerializedName("temp") val temp: String,
    @SerializedName("temp_min") val tempMin: String,
    @SerializedName("temp_max") val tempMax: String
)