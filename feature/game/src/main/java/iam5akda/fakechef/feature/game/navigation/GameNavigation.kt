package iam5akda.fakechef.feature.game.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import iam5akda.fakechef.core.common.extension.uriEncode
import iam5akda.fakechef.feature.game.view.lobby.composeLobbyScreen
import iam5akda.fakechef.feature.game.view.register.composeRegisterScreen

@Composable
internal fun GameNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "register",
    ) {
        composeRegisterScreen(
            onClickJoin = navController::directionToLobby
        )
        composeLobbyScreen()
    }
}

private fun NavController.directionToLobby(room: String, name: String) {
    val encodedRoom = room.uriEncode()
    val encodedName = name.uriEncode()
    navigate("lobby/$encodedRoom/$encodedName")
}