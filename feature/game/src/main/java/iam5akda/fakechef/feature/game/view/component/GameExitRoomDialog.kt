package iam5akda.fakechef.feature.game.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.game.R

@Composable
fun GameExitLobbyDialog(
    onClickYes: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onClickYes) {
                Text(
                    text = stringResource(id = R.string.common_yes)
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(id = R.string.common_no)
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.dialog_exit_title),
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = stringResource(id = R.string.dialog_exit_message)
            )
        }
    )
}

@PhonePreviewDayAndNight
@Composable
private fun GameExitLobbyDialogPreview() {
    FakeChefTheme {
        GameExitLobbyDialog(onClickYes = {}, onDismiss = {})
    }
}