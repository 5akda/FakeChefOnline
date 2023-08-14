package iam5akda.fakechef.feature.game.view.register

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal fun NavGraphBuilder.composeRegisterScreen(
    onClickJoin: (room: String, name: String) -> Unit
) {
    composable(
        route = "register",
    ) {
        GameRegisterScreen(onClickJoin = onClickJoin)
    }
}