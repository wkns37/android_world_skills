package ru.wkns37.worldskills.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T>(initial: T) : ViewModel() {

    private var state = mutableStateOf(initial)

    protected fun updateState(state: T) {
        this.state.value = state
    }

    fun currentState(): State<T> = state
}