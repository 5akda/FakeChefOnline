package iam5akda.fakechef.feature.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import iam5akda.fakechef.feature.home.view.menu.MenuScreen

@Composable
internal fun HomeNavigation(
    onClickStartGame: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable(route = "menu") {
            MenuScreen(
                onClickCreateRoom = onClickStartGame,
                onClickHistory = {},
                onClickHelp = {}
            )
        }
    }
}