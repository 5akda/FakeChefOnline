package iam5akda.fakechef.feature.game.view.lobby

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

internal fun NavGraphBuilder.composeLobbyScreen() {
    composable(
        route = "lobby/{room}/{name}",
        arguments = listOf(
            GameLobbyArgs.room,
            GameLobbyArgs.name
        )
    ) {
        Surface {
            Text(
                text = it.arguments?.getString(GameLobbyArgs.name.name) ?: "null",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
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