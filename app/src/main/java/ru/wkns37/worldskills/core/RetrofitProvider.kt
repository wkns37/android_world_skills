package ru.wkns37.worldskills.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitProvider {

    fun retrofit(): Retrofit

    class Base : RetrofitProvider {

        override fun retrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private companion object {
            const val BASE_URL = "https://api.open-meteo.com/v1/"
        }
    }
}