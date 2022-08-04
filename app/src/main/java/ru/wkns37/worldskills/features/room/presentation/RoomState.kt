package ru.wkns37.worldskills.features.room.presentation

sealed interface RoomState {

    val loading: Boolean
    val users: List<UserUi>

    object Loading : RoomState {

        override val loading = true
        override val users = emptyList<UserUi>()
    }

    object None : RoomState {

        override val loading = false
        override val users = emptyList<UserUi>()
    }

    data class Loaded(
        override val users: List<UserUi>
    ) : RoomState {

        override val loading = false
    }
}