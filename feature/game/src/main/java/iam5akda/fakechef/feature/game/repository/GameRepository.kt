package iam5akda.fakechef.feature.game.repository

import iam5akda.fakechef.feature.game.model.GameLobbyData
import iam5akda.fakechef.feature.game.model.GamePlayerData
import iam5akda.fakechef.feature.game.model.GameSessionStatus
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun joinerRegister(roomCode: String, yourName: String): Flow<GamePlayerData>
    fun joinerStreamSession(roomCode: String): Flow<GameLobbyData>
    fun joinerLeaveRoom(roomCode: String, tempUserId: String): Flow<Unit>
    fun hostSetLobbyStatus(roomCode: String, status: GameSessionStatus): Flow<Unit>
    fun hostAssignRoles(roomCode: String, fakeChefId: String, headChefId: String): Flow<Unit>
}