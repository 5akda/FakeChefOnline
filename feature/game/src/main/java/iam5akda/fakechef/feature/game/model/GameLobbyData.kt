package iam5akda.fakechef.feature.game.model

data class GameLobbyData(
    val status: String = "",
    val hostId: String = "",
    val fakeChefId: String = "",
    val headChefId: String = "",
    val encodedDish: String = "",
    val players: HashMap<String, GamePlayerData>? = null
) {
    fun getPlayerList(): List<GamePlayerData> {
        return players?.let { hashMap ->
            hashMap.toList()
                .map { it.second }
                .sortedBy { it.registeredTime }
        } ?: emptyList()
    }

    fun getHostPlayer(): GamePlayerData {
        return getPlayerList().find {
            it.tempUserId == hostId
        } ?: GamePlayerData("Something went wrong!")
    }

    fun isHost(playerId: String): Boolean = playerId == hostId
}