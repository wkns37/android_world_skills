package ru.wkns37.worldskills.features.splash.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigation: SplashNavigation) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Splash",
            modifier = Modifier.align(Alignment.Center)
        )
    }

    LaunchedEffect(key1 = Unit) {
        delay(750)
        navigation.showMain()
    }
}