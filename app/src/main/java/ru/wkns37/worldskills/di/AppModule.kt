package ru.wkns37.worldskills.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.wkns37.worldskills.core.Dispatchers
import ru.wkns37.worldskills.core.RetrofitProvider
import ru.wkns37.worldskills.core.RoomProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun dispatchers(): Dispatchers = Dispatchers.Base()

    @Provides
    @Singleton
    fun retrofitProvider(): RetrofitProvider = RetrofitProvider.Base()

    @Provides
    @Singleton
    fun roomProvider(@ApplicationContext context: Context): RoomProvider =
        RoomProvider.Base(context)
}

