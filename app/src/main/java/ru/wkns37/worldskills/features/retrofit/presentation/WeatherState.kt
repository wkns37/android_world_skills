package ru.wkns37.worldskills.features.retrofit.presentation

interface WeatherState {

    val loading: Boolean
    val weatherUi: WeatherUi

    object Loading : WeatherState {

        override val loading = true
        override val weatherUi = WeatherUi.None
    }

    object None : WeatherState {

        override val loading = false
        override val weatherUi = WeatherUi.None
    }

    data class Loaded(
        override val weatherUi: WeatherUi
    ) : WeatherState {

        override val loading = false
    }
}