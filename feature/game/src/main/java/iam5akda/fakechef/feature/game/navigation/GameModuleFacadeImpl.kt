package iam5akda.fakechef.feature.game.navigation

import android.content.Context
import iam5akda.fakechef.core.common.facade.GameModuleFacade
import iam5akda.fakechef.feature.game.GameActivity
import javax.inject.Inject

class GameModuleFacadeImpl @Inject constructor() : GameModuleFacade {
    override fun navigate(context: Context) {
        context.startActivity(GameActivity.getIntent(context))
    }
}