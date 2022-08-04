package ru.wkns37.worldskills.features.retrofit.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.wkns37.worldskills.core.BaseViewModel
import ru.wkns37.worldskills.core.Dispatchers
import ru.wkns37.worldskills.di.RetrofitWeatherRepository
import ru.wkns37.worldskills.features.retrofit.data.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    @RetrofitWeatherRepository private val repository: WeatherRepository,
    private val dispatchers: Dispatchers
) : BaseViewModel<WeatherState>(WeatherState.None) {

    fun updateWeather() {
        dispatchers.launchBackground(viewModelScope) {
            dispatchers.changeToUI { updateState(WeatherState.Loading) }
            val weatherUi = repository.currentWeather()
            dispatchers.changeToUI { updateState(WeatherState.Loaded(weatherUi)) }
        }
    }
}