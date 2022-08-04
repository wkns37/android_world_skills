package ru.wkns37.worldskills.features.retrofit.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wkns37.worldskills.navigation.RootNavHost
import ru.wkns37.worldskills.navigation.RootNavigation

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val state by viewModel.currentState()
        if (state.loading) {
            CircularProgressIndicator()
        } else if (state.weatherUi == WeatherUi.None) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("No weather info yet")
                Spacer(Modifier.height(12.dp))
                Button(onClick = viewModel::updateWeather) {
                    Text("Update")
                }
            }
        } else {
            Column {
                Text("Wind Speed: ${state.weatherUi.windSpeed}")
                Text("Wind Direction: ${state.weatherUi.windDirection}")
                Text("Temperature: ${state.weatherUi.temperature}")
            }
        }
    }
}