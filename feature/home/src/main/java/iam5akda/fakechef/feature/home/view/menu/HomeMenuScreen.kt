package iam5akda.fakechef.feature.home.view.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.home.R

@Composable
internal fun HomeMenuScreen(
    viewModel: HomeMenuViewModel = hiltViewModel(),
    onClickCreateRoom: () -> Unit,
    onClickHistory: () -> Unit,
    onClickHelp: () -> Unit
) {

    val animatedAppName by viewModel.appNameStateFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.startAppNameAnimation()
    }

    HomeMenuScreenLayout(
        animatedAppName = animatedAppName,
        onClickCreateRoom = onClickCreateRoom,
        onClickHistory = onClickHistory,
        onClickHelp = onClickHelp
    )
}

@Composable
private fun HomeMenuScreenLayout(
    animatedAppName: String,
    onClickCreateRoom: () -> Unit,
    onClickHistory: () -> Unit,
    onClickHelp: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        AnimatedAppNameView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .align(Alignment.TopCenter),
            animatedAppName = animatedAppName
        )
        FeatureSectionView(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .align(Alignment.BottomCenter),
            onClickCreateRoom = onClickCreateRoom,
            onClickHistory = onClickHistory,
            onClickHelp = onClickHelp
        )
        Image(
            modifier = Modifier
                .height(256.dp)
                .width(256.dp)
                .align(Alignment.Center),
            painter = painterResource(id = iam5akda.fakechef.core.design.R.drawable.ic_menu_nachos),
            contentDescription = null
        )
    }
}

@Composable
private fun AnimatedAppNameView(
    modifier: Modifier,
    animatedAppName: String
) {
    Text(
        modifier = modifier,
        text = animatedAppName,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.displayMedium,
    )
}

@Composable
private fun FeatureSectionView(
    modifier: Modifier,
    onClickCreateRoom: () -> Unit,
    onClickHistory: () -> Unit,
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
                onClick = { onClickHistory.invoke() },
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
        Text(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .alpha(0.2f),
            text = stringResource(id = R.string.credit),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@PhonePreviewDayAndNight
@Composable
private fun MenuScreenPreview() {
    FakeChefTheme {
        HomeMenuScreenLayout(
            animatedAppName = ("Fake Chef"),
            onClickCreateRoom = {},
            onClickHistory = {},
            onClickHelp = {}
        )
    }
}