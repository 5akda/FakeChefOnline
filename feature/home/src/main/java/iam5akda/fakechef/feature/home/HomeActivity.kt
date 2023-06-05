package iam5akda.fakechef.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.design.theme.FakeChefTheme

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeChefTheme {
                HomeNavigation(onClickStartGame = ::startGame)
            }
        }
    }

    private fun startGame() {
        Toast.makeText(this, "Navigate to Game Activity", Toast.LENGTH_LONG).show()
    }

    companion object {
        fun navigate(context: Context) {
            Intent(context, HomeActivity::class.java)
                .also(context::startActivity)
        }
    }
}