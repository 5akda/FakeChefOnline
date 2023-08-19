package iam5akda.fakechef.feature.game.repository

import iam5akda.fakechef.core.common.annotation.IODispatcher
import iam5akda.fakechef.core.realtime.RealtimeDatabaseUtility
import iam5akda.fakechef.feature.game.model.GameLobbyData
import iam5akda.fakechef.feature.game.model.GamePlayerData
import iam5akda.fakechef.feature.game.model.GameSessionStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject

class GameRealtimeSource @Inject constructor(
    private val realtimeDatabaseUtility: RealtimeDatabaseUtility,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : GameRepository {

    override fun joinerRegister(roomCode: String, yourName: String): Flow<GamePlayerData> {
        val joinerInfo = GamePlayerData(
            name = yourName,
            registeredTime = System.currentTimeMillis(),
            tempUserId = UUID.randomUUID().toString()
        )
        return realtimeDatabaseUtility.setRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode/players/${joinerInfo.tempUserId}",
            value = joinerInfo
        )
            .map { joinerInfo }
            .flowOn(dispatcher)
    }

    override fun joinerStreamSession(roomCode: String): Flow<GameLobbyData> {
        return realtimeDatabaseUtility.getRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode",
            type = GameLobbyData::class.java
        )
            .flowOn(dispatcher)
    }

    override fun joinerLeaveRoom(roomCode: String, tempUserId: String): Flow<Unit> {
        return realtimeDatabaseUtility.removeRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode/players/$tempUserId"
        )
            .flowOn(dispatcher)
    }

    override fun hostSetLobbyStatus(roomCode: String, status: GameSessionStatus): Flow<Unit> {
        return realtimeDatabaseUtility.setRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode/status",
            value = status.name
        )
            .flowOn(dispatcher)
    }

    override fun hostAssignRoles(
        roomCode: String,
        fakeChefId: String,
        headChefId: String
    ): Flow<Unit> {
        val assignFakeChefFlow = realtimeDatabaseUtility.setRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode/fakeChefId",
            value = fakeChefId
        )
        val assignHeadChefFlow = realtimeDatabaseUtility.setRealtimeValue(
            reference = "$LOBBY_PATH/$roomCode/headChefId",
            value = headChefId
        )
        return assignFakeChefFlow
            .flatMapConcat { assignHeadChefFlow }
            .flowOn(dispatcher)
    }

    companion object {
        private const val LOBBY_PATH = "lobby"
    }
}