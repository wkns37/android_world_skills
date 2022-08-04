package ru.wkns37.worldskills.features.retrofit.data

import ru.wkns37.worldskills.features.retrofit.presentation.WeatherUi
import java.lang.Exception

interface WeatherRepository {

    suspend fun currentWeather(): WeatherUi

    class Base(
        private val service: WeatherService,
        private val mapper: WeatherData.Mapper<WeatherUi>
    ) : WeatherRepository {

        override suspend fun currentWeather(): WeatherUi = try {
            val weatherData = service.currentWeather(55.7558, 37.6173)
            weatherData.map(mapper)
        } catch (e: Exception) {
            // NOTE(wkns37): bad approach
            WeatherUi.None
        }
    }
}