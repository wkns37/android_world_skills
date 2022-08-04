package ru.wkns37.worldskills.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

interface Navigation {

    interface Provider<T : Navigation> {

        val navigation: T
            @Composable
            @ReadOnlyComposable
            get
    }
}