package com.example.weatherapp2.features.weather_screen.data.api

import com.example.weatherapp2.features.weather_screen.data.api.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

//api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
//37065663bb276cbf619fbe6c9a8e2e5a
interface WeatherApi {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") city_name: String,
        @Query("appid") api_key: String = "37065663bb276cbf619fbe6c9a8e2e5a",
        @Query("units") units: String = "metric"
    ) : WeatherModel
}

