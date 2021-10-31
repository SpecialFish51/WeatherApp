package com.example.weatherapp.features.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(@SerializedName("main") val main: WeatherMainModel)
