package ru.wkns37.worldskills.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.wkns37.worldskills.core.RoomProvider
import ru.wkns37.worldskills.features.room.data.UsersDatabase
import ru.wkns37.worldskills.features.room.data.UsersRepository
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RoomUsersRepository

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalUsersRepository

@Module
@InstallIn(SingletonComponent::class)
object UsersRepositoryModule {

    @Provides
    @Singleton
    @RoomUsersRepository
    fun room(roomProvider: RoomProvider): UsersRepository {
        val database = roomProvider.database(UsersDatabase::class.java, "room_database")
        val userDao = database.provideDao()
        return UsersRepository.Room(userDao)
    }

    @Provides
    @Singleton
    @LocalUsersRepository
    fun local(): UsersRepository = UsersRepository.Local()
}