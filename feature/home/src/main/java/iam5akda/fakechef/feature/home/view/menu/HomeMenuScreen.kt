package iam5akda.fakechef.feature.home.view.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    onClickPlay: () -> Unit,
    onClickHistory: () -> Unit,
    onClickAbout: () -> Unit
) {
    val animatedAppNameState = viewModel.appNameStateFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.startAppNameAnimation()
    }

    HomeMenuScreenLayout(
        animatedAppNameState = animatedAppNameState,
        foodImageResId = viewModel.foodImageResId,
        onClickPlay = onClickPlay,
        onClickHistory = onClickHistory,
        onClickAbout = onClickAbout
    )
}

@Composable
private fun HomeMenuScreenLayout(
    animatedAppNameState: State<String>,
    foodImageResId: Int,
    onClickPlay: () -> Unit,
    onClickHistory: () -> Unit,
    onClickAbout: () -> Unit
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
            animatedAppName = animatedAppNameState
        )
        FeatureSectionView(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .align(Alignment.BottomCenter),
            onClickPlay = onClickPlay,
            onClickHistory = onClickHistory,
            onClickAbout = onClickAbout
        )
        if (maxHeight / maxWidth > 1.6f) {
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 72.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                painter = painterResource(id = foodImageResId),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun AnimatedAppNameView(
    modifier: Modifier,
    animatedAppName: State<String>
) {
    Text(
        modifier = modifier,
        text = animatedAppName.value,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.displayMedium,
    )
}

@Composable
private fun FeatureSectionView(
    modifier: Modifier,
    onClickPlay: () -> Unit,
    onClickHistory: () -> Unit,
    onClickAbout: () -> Unit
) {
    Column(modifier = modifier) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClickPlay
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 2.dp),
                text = stringResource(id = R.string.play),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
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
                onClick = onClickHistory,
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    text = stringResource(id = R.string.history),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            OutlinedButton(
                modifier = Modifier
                    .weight(1f),
                onClick = onClickAbout,
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    text = stringResource(id = R.string.about),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall
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
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@PhonePreviewDayAndNight
@Composable
private fun HomeMenuScreenPreview() {
    FakeChefTheme {
        HomeMenuScreenLayout(
            animatedAppNameState = remember { mutableStateOf("Fake Chef") },
            foodImageResId = iam5akda.fakechef.core.design.R.drawable.ic_menu_burger,
            onClickPlay = {},
            onClickHistory = {},
            onClickAbout = {}
        )
    }
}