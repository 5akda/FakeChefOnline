package iam5akda.fakechef.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import iam5akda.fakechef.feature.home.view.menu.HomeMenuScreen

@Composable
internal fun HomeNavigation(
    animatedAppNameRepetition: Int,
    onClickCreateRoom: () -> Unit,
    onClickRateAndReview: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu/{repetition}",
    ) {
        composable(
            route = "menu/{repetition}",
            arguments = listOf(
                navArgument("repetition") {
                    type = NavType.IntType
                    defaultValue = animatedAppNameRepetition
                }
            )
        ) {
            HomeMenuScreen(
                onClickCreateRoom = onClickCreateRoom,
                onClickHistory = navController.directionToHistory(),
                onClickRateAndReview = onClickRateAndReview
            )
        }

        composable(
            route = "history"
        ) {
            Text(text = "coming soon")
        }
    }
}

private fun NavController.directionToHistory(): () -> Unit = {
    this.navigate("history")
}