package ru.wkns37.worldskills.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wkns37.worldskills.core.Destination
import ru.wkns37.worldskills.core.Navigation
import ru.wkns37.worldskills.features.splash.presentation.SplashNavigation

private object Splash : Destination("splash")
private object Main : Destination("main")

interface RootNavigation : SplashNavigation {

    class Base(
        private val navController: NavController
    ) : RootNavigation {

        override fun showMain() {
            navController.navigate(Main.route) {
                popUpTo(Splash.route) {
                    inclusive = true
                }
            }
        }
    }
}

private val LocalRootNavigation =
    staticCompositionLocalOf<RootNavigation> {
        error("RootNavigation is not available yet")
    }

object RootNavHost : Navigation.Provider<RootNavigation> {

    override val navigation
        @Composable
        @ReadOnlyComposable
        get() = LocalRootNavigation.current
}

@Composable
fun RootNavHost(
    navController: NavHostController,
    splash: @Composable () -> Unit,
    main: @Composable () -> Unit
) {
    val navigation = remember(navController) {
        RootNavigation.Base(navController)
    }

    CompositionLocalProvider(
        LocalRootNavigation provides navigation
    ) {
        NavHost(
            navController = navController,
            startDestination = Splash.route
        ) {
            composable(Splash.route) {
                splash()
            }
            composable(Main.route) {
                main()
            }
        }
    }
}