package iam5akda.fakechef.feature.game.view.lobby

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

internal fun NavGraphBuilder.composeLobbyScreen(
    onBack: () -> Unit
) {
    composable(
        route = "lobby/{room}/{name}",
        arguments = listOf(
            GameLobbyArgs.room,
            GameLobbyArgs.name
        )
    ) {
        GameLobbyScreen(
            backToRegister = onBack
        )
    }
}

internal object GameLobbyArgs {
    val room = navArgument("room") {
        type = NavType.StringType
        nullable = false
    }
    val name = navArgument("name") {
        type = NavType.StringType
        nullable = false
    }
}