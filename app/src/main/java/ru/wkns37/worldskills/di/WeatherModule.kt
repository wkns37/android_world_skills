package ru.wkns37.worldskills.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.wkns37.worldskills.core.RetrofitProvider
import ru.wkns37.worldskills.features.retrofit.data.WeatherData
import ru.wkns37.worldskills.features.retrofit.data.WeatherRepository
import ru.wkns37.worldskills.features.retrofit.data.WeatherService
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitWeatherRepository

@Module
@InstallIn(SingletonComponent::class)
object WeatherRepositoryModule {

    @Provides
    @Singleton
    @RetrofitWeatherRepository
    fun retrofit(retrofitProvider: RetrofitProvider): WeatherRepository {
        val service = retrofitProvider.retrofit().create(WeatherService::class.java)
        val mapper = WeatherData.Mapper.Base()
        return WeatherRepository.Base(service, mapper)
    }
}