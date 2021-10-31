package com.example.weatherapp.features.weather_screen.data.api

import com.example.weatherapp.features.weather_screen.data.model.WeatherModel
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

//api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
//37065663bb276cbf619fbe6c9a8e2e5a
interface WeatherApi {
    @GET("/weather")
    fun getWeather(
        @Query("q") city_name: String,
        @Query("appid") api_key: String = "ca40bf0a4862502ed0d57284fa195b04",
        @Query("units") units: String = "metric"
    ) : WeatherModel
}