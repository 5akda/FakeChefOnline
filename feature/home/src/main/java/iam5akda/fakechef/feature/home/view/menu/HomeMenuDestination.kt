package iam5akda.fakechef.feature.home.view.menu

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

internal fun NavGraphBuilder.composeMenuScreen(
    onClickPlay: () -> Unit,
    onClickHistory: () -> Unit,
    onClickAbout: () -> Unit
) {
    composable(
        route = "menu/{${HomeMenuArgs.repetition.name}}",
        arguments = listOf(
            HomeMenuArgs.repetition
        )
    ) {
        HomeMenuScreen(
            onClickPlay = onClickPlay,
            onClickHistory = onClickHistory,
            onClickAbout = onClickAbout
        )
    }
}

internal object HomeMenuArgs {
    val repetition = navArgument("menuRepetition") {
        type = NavType.IntType
        defaultValue = 3
    }
}