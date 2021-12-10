package com.example.weatherapp2.features.wind_screen.ui


import com.example.weatherapp2.base.BaseViewModel
import com.example.weatherapp2.base.Event
import com.example.weatherapp2.features.settings_screen.domain.SettingsInteractor
import com.example.weatherapp2.features.weather_screen.domain.WeatherInteractor
import com.example.weatherapp2.features.weather_screen.domain.model.WindDomainModel


class WindScreenViewModel(
    private val weatherInteractor: WeatherInteractor,
    private val settingsInteractor: SettingsInteractor
) : BaseViewModel<ViewState>() {
    init {
        processUiEvent(UIEvent.GetWind)
    }

    override fun initialViewState(): ViewState {
        return ViewState(WindDomainModel(0.0, 0), "")
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.GetWind -> {
                val cityName = settingsInteractor.getSettings().city
                weatherInteractor.getWeather(cityName).fold(
                    onSuccess = { processDataEvent(DataEvent.SuccessWindGetting(it.windDomainModel)) },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorWindGetting(
                                it.localizedMessage ?: "Error"
                            )
                        )
                    }
                )
            }
            is DataEvent.SuccessWindGetting -> {
                return previousState.copy(windDomainModel = event.windDomainModel)
            }
            is DataEvent.ErrorWindGetting -> {
                return previousState.copy(errorMessage = event.error)
            }
        }
        return null
    }
}