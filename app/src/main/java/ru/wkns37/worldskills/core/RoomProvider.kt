package ru.wkns37.worldskills.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

interface RoomProvider {

    fun <T : RoomDatabase> database(clazz: Class<T>, name: String): T

    class Base(private val context: Context) : RoomProvider {

        override fun <T : RoomDatabase> database(clazz: Class<T>, name: String): T {
            return Room.databaseBuilder(context, clazz, name)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}