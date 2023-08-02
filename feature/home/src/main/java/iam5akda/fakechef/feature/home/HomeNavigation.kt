package iam5akda.fakechef.feature.home

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import iam5akda.fakechef.feature.home.view.menu.MenuScreen

@Composable
internal fun HomeNavigation(animatedAppNameRepetition: Int) {
    val navController = rememberNavController()
    val context = LocalContext.current

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
            MenuScreen(
                onClickCreateRoom = context::directionToGame,
                onClickHistory = navController::directionToHistory,
                onClickHelp = navController::directionToHelp
            )
        }

        composable(
            route = "history"
        ) {
            Text(text = "under construction")
        }

        composable(
            route = "help"
        ) {
            Text(text = "under construction")
        }
    }
}

private fun NavController.directionToHistory() {
    this.navigate("history")
}

private fun NavController.directionToHelp() {
    this.navigate("help")
}

private fun Context.directionToGame() {
    Toast.makeText(this, "currently working :)", Toast.LENGTH_SHORT).show()
}