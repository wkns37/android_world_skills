package ru.wkns37.worldskills.features.room.presentation

interface UserUi {

    val id: Int
    val name: String
    val age: Int

    data class Base(
        override val id: Int,
        override val name: String,
        override val age: Int
    ) : UserUi
}