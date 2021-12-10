package com.example.weatherapp2.features.weather_screen.di


import com.example.weatherapp2.features.settings_screen.domain.SettingsInteractor
import com.example.weatherapp2.features.weather_screen.data.api.WeatherApi
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRemoteSource
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepo
import com.example.weatherapp2.features.weather_screen.data.api.WeatherRepoImpl
import com.example.weatherapp2.features.weather_screen.domain.WeatherInteractor
import com.example.weatherapp2.features.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"
val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
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
        WeatherScreenViewModel(get<WeatherInteractor>(), get<SettingsInteractor>())
    }
}