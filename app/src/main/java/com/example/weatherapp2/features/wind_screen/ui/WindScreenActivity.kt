package com.example.weatherapp2.features.wind_screen.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weatherapp2.features.wind_screen.ui.WindScreenViewModel
import com.example.weatherapp2.R
import com.example.weatherapp2.features.weather_screen.domain.model.WindDomainModel
import org.koin.android.viewmodel.ext.android.viewModel


class WindScreenActivity: AppCompatActivity() {
    private val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.liveData.observe(this, Observer(::render))
        windScreenViewModel.requestWind()
    }

    private fun render(state: WindDomainModel) {
        findViewById<TextView>(R.id.tvWindSpeed).text = state.speed.toString()
    }
}