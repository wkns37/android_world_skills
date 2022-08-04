package ru.wkns37.worldskills.features.retrofit.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast?current_weather=true")
    suspend fun currentWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): WeatherData.Base
}
