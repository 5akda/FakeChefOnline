package iam5akda.fakechef.core.design.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight

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

@PhonePreviewDayAndNight
@Composable
fun PreviewGiantLoadingView() {
    FakeChefTheme {
        Surface {
            GiantLoadingView(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}