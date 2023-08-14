package iam5akda.fakechef.feature.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.design.theme.FakeChefTheme

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeChefTheme {
                Surface {
                    Text(text = stringResource(id = R.string.title_activity_game))
                }
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, GameActivity::class.java)
    }
}