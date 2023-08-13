package iam5akda.fakechef.feature.home.navigation

import android.content.Context
import iam5akda.fakechef.core.common.facade.HomeModuleFacade
import iam5akda.fakechef.feature.home.HomeActivity
import javax.inject.Inject

class HomeModuleFacadeImpl @Inject constructor() : HomeModuleFacade {
    override fun navigate(context: Context) {
        context.startActivity(HomeActivity.getIntent(context))
    }
}