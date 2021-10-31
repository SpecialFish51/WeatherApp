package com.example.weatherapp2.features.weather_screen.di

import com.example.weatherapp2.features.weather_screen.ui.WeatherScreenViewModel
import com.example.weatherapp2.features.weather_screen.data.api.WeatherApi
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRemoteSource
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepo
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepoImpl
import com.example.weatherapp2.features.weather_screen.domain.WeatherInteractor
import com.example.weatherapp2.features.weather_screen.ui.WeatherScreenActivity
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

const val BASE_URL = "api.openweathermap.org/data/2.5"
val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single<WeatherScreenActivity>{
        WeatherScreenActivity()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }


    single<WeatherRepo> {
        WeatherRepoImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepo>())
    }

    viewModel {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}