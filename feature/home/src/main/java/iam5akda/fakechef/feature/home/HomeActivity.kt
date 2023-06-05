package iam5akda.fakechef.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.design.theme.FakeChefTheme

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeChefTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(text = "Home Screen")
                }
            }
        }
    }

    companion object {
        fun navigate(context: Context) {
            Intent(context, HomeActivity::class.java)
                .also(context::startActivity)
        }
    }
}