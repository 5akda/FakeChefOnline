package iam5akda.fakechef.feature.game.model

sealed interface GameUiState {
    object Loading : GameUiState

    data class Idle(
        val gameLobbyData: GameLobbyData,
        val roomCode: String,
        val tempUserId: String
    ) : GameUiState

    data class Ordering(
        val roomCode: String,
        val tempUserId: String
    ) : GameUiState

    object Kicked : GameUiState
}