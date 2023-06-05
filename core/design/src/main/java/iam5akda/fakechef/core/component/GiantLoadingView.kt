package iam5akda.fakechef.core.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GiantLoadingView(
    modifier: Modifier
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .padding(64.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 24.dp,
        )
    }
}