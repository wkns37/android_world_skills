package ru.wkns37.worldskills.features.retrofit.data

import com.google.gson.annotations.SerializedName
import ru.wkns37.worldskills.features.retrofit.presentation.WeatherUi

data class CurrentWeather(
    @SerializedName("windspeed") val windSpeed: Double,
    @SerializedName("weathercode") val weatherCode: Int,
    @SerializedName("winddirection") val windDirection: Int,
    @SerializedName("time") val time: String,
    @SerializedName("temperature") val temperature: Double
)

interface WeatherData {

    fun <T> map(mapper: Mapper<T>): T

    data class Base(
        @SerializedName("utc_offset_seconds") private val utcOffsetSeconds: Int,
        @SerializedName("current_weather") private val currentWeather: CurrentWeather,
        @SerializedName("latitude") private val latitude: Double,
        @SerializedName("longitude") private val longitude: Double,
        @SerializedName("elevation") private val elevation: Double,
        @SerializedName("generationtime_ms") private val generationTimeMilliseconds: Double
    ) : WeatherData {

        override fun <T> map(mapper: Mapper<T>) = mapper.map(
            currentWeather.windSpeed,
            currentWeather.windDirection,
            currentWeather.temperature
        )
    }

    interface Mapper<T> {

        fun map(
            windSpeed: Double,
            windDirection: Int,
            temperature: Double
        ): T

        class Base : Mapper<WeatherUi> {

            override fun map(windSpeed: Double, windDirection: Int, temperature: Double) =
                WeatherUi.Base(windSpeed, windDirection, temperature)
        }
    }
}
