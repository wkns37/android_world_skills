package ru.wkns37.worldskills

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.wkns37.worldskills.features.retrofit.presentation.WeatherScreen
import ru.wkns37.worldskills.features.room.presentation.RoomScreen
import ru.wkns37.worldskills.features.splash.presentation.SplashScreen
import ru.wkns37.worldskills.navigation.MainNavHost
import ru.wkns37.worldskills.navigation.RootNavHost
import ru.wkns37.worldskills.ui.theme.WorldSkillsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WorldSkillsTheme {
                RootNavHost(
                    rememberNavController(),
                    splash = {
                        SplashScreen(RootNavHost.navigation)
                    },
                    main = {
                        MainNavHost(
                            rememberNavController(),
                            room = {
                                RoomScreen(hiltViewModel())
                            },
                            weather = {
                                WeatherScreen(hiltViewModel())
                            }
                        )
                    }
                )
            }
        }
    }
}
