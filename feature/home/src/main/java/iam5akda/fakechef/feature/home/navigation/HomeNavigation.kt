package iam5akda.fakechef.feature.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import iam5akda.fakechef.feature.home.view.history.composeHistoryScreen
import iam5akda.fakechef.feature.home.view.menu.HomeMenuArgs
import iam5akda.fakechef.feature.home.view.menu.composeMenuScreen

@Composable
internal fun HomeNavigation(
    onClickPlay: () -> Unit,
    onClickRateAndReview: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu/{${HomeMenuArgs.repetition.name}}",
    ) {
        composeMenuScreen(
            onClickPlay = onClickPlay,
            onClickHistory = navController::directionToHistory,
            onClickRateAndReview = onClickRateAndReview
        )

        composeHistoryScreen()
    }
}

private fun NavController.directionToHistory() {
    navigate("history")
}