package iam5akda.fakechef.feature.home.view.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.home.R

@Composable
internal fun MenuScreen(
    viewModel: MenuViewModel = hiltViewModel(),
    onClickCreateRoom: () -> Unit,
    onClickHistory: (String) -> Unit,
    onClickHelp: () -> Unit
) {
    val animatedAppName by viewModel.animationStateFlow.collectAsStateWithLifecycle()

    MenuLayoutContent(
        animatedAppName = animatedAppName,
        onClickCreateRoom = onClickCreateRoom,
        onClickHistory = onClickHistory,
        onClickHelp = onClickHelp
    )
}

@Composable
private fun MenuLayoutContent(
    animatedAppName: String,
    onClickCreateRoom: () -> Unit,
    onClickHistory: (String) -> Unit,
    onClickHelp: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        MenuAnimatedAppName(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp),
            animatedAppName = animatedAppName
        )
        MenuFeatureSection(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .align(Alignment.BottomCenter),
            onClickCreateRoom = onClickCreateRoom,
            onClickHistory = onClickHistory,
            onClickHelp = onClickHelp
        )
    }
}

@Composable
private fun MenuAnimatedAppName(
    modifier: Modifier,
    animatedAppName: String
) {
    Text(
        modifier = modifier,
        text = animatedAppName,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun MenuFeatureSection(
    modifier: Modifier,
    onClickCreateRoom: () -> Unit,
    onClickHistory: (String) -> Unit,
    onClickHelp: () -> Unit
) {
    Column(modifier = modifier) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClickCreateRoom
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 2.dp),
                text = stringResource(id = R.string.play),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .weight(1f),
                onClick = { onClickHistory.invoke("NOT FINISH") },
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    text = stringResource(id = R.string.history),
                    fontWeight = FontWeight.Bold
                )
            }
            OutlinedButton(
                modifier = Modifier
                    .weight(1f),
                onClick = onClickHelp,
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    text = stringResource(id = R.string.help),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@PhonePreviewDayAndNight
@Composable
private fun HomeScreenPreview() {
    FakeChefTheme {
        MenuLayoutContent(
            animatedAppName = "Fake Chef",
            onClickCreateRoom = {},
            onClickHistory = {},
            onClickHelp = {}
        )
    }
}