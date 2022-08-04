package ru.wkns37.worldskills.features.room.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.wkns37.worldskills.core.BaseViewModel
import ru.wkns37.worldskills.core.Dispatchers
import ru.wkns37.worldskills.di.LocalUsersRepository
import ru.wkns37.worldskills.di.RoomUsersRepository
import ru.wkns37.worldskills.features.room.data.UsersRepository
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    @LocalUsersRepository private val repository: UsersRepository,
    private val dispatchers: Dispatchers
) : BaseViewModel<RoomState>(RoomState.None) {

    fun updateList() {
        dispatchers.launchBackground(viewModelScope) {
            dispatchers.changeToUI { updateState(RoomState.Loading) }
            val users = repository.getUsers()
            dispatchers.changeToUI { updateState(RoomState.Loaded(users)) }
        }
    }
}