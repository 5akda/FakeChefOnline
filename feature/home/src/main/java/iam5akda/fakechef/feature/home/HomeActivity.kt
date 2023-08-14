package iam5akda.fakechef.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.common.facade.GameModuleFacade
import iam5akda.fakechef.core.design.theme.FakeChefTheme
import iam5akda.fakechef.feature.home.navigation.HomeNavigation
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    @Inject
    lateinit var gameModuleFacade: GameModuleFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeChefTheme {
                HomeNavigation(
                    onClickPlay = ::navigateToGameActivity,
                    onClickRateAndReview = ::requestInAppReview
                )
            }
        }
    }

    private fun requestInAppReview() {
        //TODO("Implement In-App Review API")
    }

    private fun navigateToGameActivity() {
        gameModuleFacade.navigate(this)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}