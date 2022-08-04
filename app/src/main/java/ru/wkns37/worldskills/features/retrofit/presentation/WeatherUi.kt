package ru.wkns37.worldskills.features.retrofit.presentation

interface WeatherUi {

    val windSpeed: Double
    val windDirection: Int
    val temperature: Double

    data class Base(
        override val windSpeed: Double,
        override val windDirection: Int,
        override val temperature: Double
    ) : WeatherUi

    object None : WeatherUi {

        override val windSpeed = 0.0
        override val windDirection = 0
        override val temperature = 0.0
    }
}
