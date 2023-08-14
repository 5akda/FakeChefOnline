package iam5akda.fakechef.feature.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.feature.game.navigation.GameNavigation

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeChefTheme {
                GameNavigation()
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, GameActivity::class.java)
    }
}