package iam5akda.fakechef.feature.game.view.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import iam5akda.fakechef.core.common.extension.lettersAndDigits
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.core.design.util.PhonePreviewDayAndNight
import iam5akda.fakechef.feature.game.R

@Composable
internal fun GameRegisterScreen(
    onClickJoin: (code: String, name: String) -> Unit
) {
    GameRegisterScreenLayout(onClickJoin = onClickJoin)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GameRegisterScreenLayout(
    onClickJoin: (code: String, name: String) -> Unit
) {
    var roomCodeText by remember { mutableStateOf("") }
    var yourNameText by remember { mutableStateOf("") }

    FakeChefTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                val focusManager = LocalFocusManager.current

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = roomCodeText,
                    onValueChange = { roomCodeText = it.lettersAndDigits() },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 18.sp
                    ),
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_room_code)
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_room_24),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                        )
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    value = yourNameText,
                    onValueChange = { yourNameText = it.lettersAndDigits() },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 18.sp
                    ),
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_your_name)
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_name_24),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                        )
                    }
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
                    .align(Alignment.BottomCenter),
                onClick = {
                    onClickJoin.invoke(roomCodeText, yourNameText)
                },
                enabled = roomCodeText.isNotEmpty() && yourNameText.isNotEmpty()
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 2.dp),
                    text = stringResource(id = R.string.button_join_room),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@PhonePreviewDayAndNight
@Composable
private fun GameRegisterScreenPreview() {
    FakeChefTheme {
        GameRegisterScreenLayout(
            onClickJoin = { _, _ -> }
        )
    }
}