package iam5akda.fakechef.feature.game.view.lobby

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import iam5akda.fakechef.core.design.component.GiantLoadingView
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.game.R
import iam5akda.fakechef.feature.game.model.GameLobbyData
import iam5akda.fakechef.feature.game.model.GamePlayerData
import iam5akda.fakechef.feature.game.model.GameUiState
import iam5akda.fakechef.feature.game.view.component.GameExitLobbyDialog
import iam5akda.fakechef.feature.game.view.component.GamePlayerItemView

@Composable
internal fun GameLobbyScreen(
    viewModel: GameLobbyViewModel = hiltViewModel(),
    backToRegister: () -> Unit
) {
    val gameUiState = viewModel.gameUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.registerAndStreamSession()
    }

    GameLobbyScreenLayout(
        gameUiState = gameUiState,
        onClickStart = viewModel::hostStartGame,
        leaveRoom = viewModel::leaveRoom,
        backToRegister = backToRegister
    )
}

@Composable
private fun GameLobbyScreenLayout(
    gameUiState: State<GameUiState>,
    onClickStart: () -> Unit,
    leaveRoom: () -> Unit,
    backToRegister: () -> Unit
) {
    LobbyExitDialogView(
        onClickYes = leaveRoom
    )

    when (val stateValue = gameUiState.value) {
        is GameUiState.Loading -> {
            GiantLoadingView(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            )
        }

        is GameUiState.Idle -> {
            LobbySuccessView(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                gameLobbyData = stateValue.gameLobbyData,
                roomCode = stateValue.roomCode,
                tempUserId = stateValue.tempUserId,
                onClickStart = onClickStart
            )
        }

        is GameUiState.Ordering -> {
            Toast.makeText(LocalContext.current, "Test:: Ordering", Toast.LENGTH_SHORT).show()
        }

        else -> {
            backToRegister.invoke()
        }
    }
}

@Composable
private fun LobbySuccessView(
    modifier: Modifier,
    gameLobbyData: GameLobbyData,
    onClickStart: () -> Unit,
    roomCode: String,
    tempUserId: String
) {
    var isGameStarting by remember {
        mutableStateOf(false)
    }
    val hostStartGame = remember {
        {
            isGameStarting = true
            onClickStart.invoke()
        }
    }

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .align(Alignment.TopStart)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                text = stringResource(R.string.lobby_room_code, roomCode),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                text = stringResource(R.string.lobby_host_name, gameLobbyData.getHostPlayer().name),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(gameLobbyData.getPlayerList()) { player ->
                    GamePlayerItemView(
                        modifier = Modifier
                            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
                            .alpha(0.7f)
                            .fillMaxWidth(),
                        playerData = player,
                        thisPlayerId = tempUserId
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .align(Alignment.BottomCenter),
            onClick = hostStartGame,
            enabled = gameLobbyData.isHost(tempUserId)
                    && !isGameStarting
                    && gameLobbyData.getPlayerList().size > 3
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 2.dp),
                text = stringResource(
                    if (gameLobbyData.getPlayerList().size > 3) {
                        R.string.button_start_game
                    } else {
                        R.string.button_not_enough_players
                    }
                ),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
private fun LobbyExitDialogView(onClickYes: () -> Unit) {

    var isShowExitDialog by remember { mutableStateOf(false) }

    if (isShowExitDialog) {
        GameExitLobbyDialog(
            onDismiss = { isShowExitDialog = false },
            onClickYes = onClickYes
        )
    }
    BackHandler(enabled = true) {
        isShowExitDialog = true
    }
}

@PhonePreviewDayAndNight
@Composable
private fun LobbySuccessLayoutPreview() {
    val data = GameLobbyData(
        players = hashMapOf(
            Pair("", GamePlayerData(name = "Nabuki"))
        )
    )
    FakeChefTheme {
        LobbySuccessView(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            gameLobbyData = data,
            onClickStart = {},
            roomCode = "987654",
            tempUserId = ""
        )
    }
}