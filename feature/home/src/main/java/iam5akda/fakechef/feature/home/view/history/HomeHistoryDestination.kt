package iam5akda.fakechef.feature.home.view.history

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal fun NavGraphBuilder.composeHistoryScreen() {
    composable(
        route = "history"
    ) {
        Text(
            text = "coming soon",
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}