package iam5akda.fakechef.feature.game.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.game.R
import iam5akda.fakechef.feature.game.model.GamePlayerData

@Composable
fun GamePlayerItemView(
    modifier: Modifier,
    playerData: GamePlayerData,
    thisPlayerId: String
) {
    Row(
        modifier = modifier
            .background(
                if (playerData.tempUserId == thisPlayerId) {
                    MaterialTheme.colorScheme.tertiaryContainer
                } else {
                    MaterialTheme.colorScheme.background
                }
            )
    ) {
        Image(
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 2.dp),
            painter = painterResource(id = R.drawable.ic_player_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 2.dp),
            text = playerData.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@PhonePreviewDayAndNight
@Composable
private fun GamePlayerItemViewPreview() {
    FakeChefTheme {
        Surface {
            GamePlayerItemView(
                modifier = Modifier
                    .fillMaxWidth(),
                playerData = GamePlayerData("User1234HasTheLongestNameIntheWorldHahahahahaahahah"),
                thisPlayerId = ""
            )
        }
    }
}