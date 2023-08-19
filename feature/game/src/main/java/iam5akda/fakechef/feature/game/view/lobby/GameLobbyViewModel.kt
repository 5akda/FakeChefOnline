package iam5akda.fakechef.feature.game.view.lobby

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iam5akda.fakechef.core.common.extension.uriDecode
import iam5akda.fakechef.feature.game.model.GameLobbyData
import iam5akda.fakechef.feature.game.model.GamePlayerData
import iam5akda.fakechef.feature.game.model.GameSessionStatus
import iam5akda.fakechef.feature.game.model.GameUiState
import iam5akda.fakechef.feature.game.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameLobbyViewModel @Inject constructor(
    private val gameRepository: GameRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val roomCode by lazy { (savedStateHandle[GameLobbyArgs.room.name] ?: "").uriDecode() }
    private val yourName by lazy { (savedStateHandle[GameLobbyArgs.name.name] ?: "").uriDecode() }

    private var playerData: GamePlayerData? = null

    private val _gameUiState = MutableStateFlow<GameUiState>(GameUiState.Loading)
    val gameUiState: StateFlow<GameUiState> = _gameUiState

    fun registerAndStreamSession() = viewModelScope.launch {
        if (playerData == null) {
            gameRepository.joinerRegister(roomCode, yourName)
                .flatMapLatest {
                    playerData = it
                    gameRepository.joinerStreamSession(roomCode)
                }
                .map { processLobbySession(it) }
                .catch { emit(GameUiState.Kicked) }
                .collect { _gameUiState.value = it }
        }
    }

    fun leaveRoom() = viewModelScope.launch {
        gameRepository.joinerLeaveRoom(roomCode, playerData?.tempUserId.orEmpty())
            .catch { _gameUiState.value = GameUiState.Kicked }
            .collect()
    }

    fun hostStartGame() = viewModelScope.launch {
        val lobbyData = (_gameUiState.value as? GameUiState.Idle)?.gameLobbyData

        lobbyData?.let {
            val mutablePlayerList = it.getPlayerList().toMutableList()
            mutablePlayerList.shuffle()

            gameRepository.hostAssignRoles(
                roomCode = roomCode,
                fakeChefId = mutablePlayerList.removeFirst().tempUserId,
                headChefId = mutablePlayerList.removeFirst().tempUserId
            )
                .flatMapLatest {
                    gameRepository.hostSetLobbyStatus(roomCode, GameSessionStatus.ORDERING)
                }
                .collect()
        }
    }

    private fun processLobbySession(data: GameLobbyData): GameUiState {
        return when (data.status) {
            GameSessionStatus.IDLE.name -> {
                val thisPlayer = data.getPlayerList().find {
                    it.tempUserId == playerData?.tempUserId
                }
                if (thisPlayer != null) {
                    GameUiState.Idle(data, roomCode, playerData?.tempUserId.orEmpty())
                } else {
                    GameUiState.Kicked
                }
            }
            GameSessionStatus.ORDERING.name -> {
                GameUiState.Ordering(roomCode, playerData?.tempUserId.orEmpty())
            }
            else -> {
                throw RuntimeException()
            }
        }
    }
}