package ru.wkns37.worldskills.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.wkns37.worldskills.R
import ru.wkns37.worldskills.core.Destination

private object Room : Destination.Bottom("room", R.drawable.ic_baseline_storage_24)
private object Weather : Destination.Bottom("weather", R.drawable.ic_baseline_cloud_24)

@Composable
fun MainNavHost(
    navController: NavHostController,
    room: @Composable () -> Unit,
    weather: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                arrayOf(Room, Weather).forEach { item ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any {
                            it.route == item.route
                        } == true,
                        icon = {
                            Icon(
                                painterResource(item.icon),
                                contentDescription = null
                            )
                        },
//                        label = { Text(stringResource(item.label)) },
//                        alwaysShowLabel = false,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Room.route
        ) {
            composable(Room.route) {
                room()
            }
            composable(Weather.route) {
                weather()
            }
        }
    }
}