package iam5akda.fakechef.online

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.core.common.facade.HomeModuleFacade
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var homeModuleFacade: HomeModuleFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().also {
            it.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        processCheckApp()
    }

    private fun processCheckApp() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(1000L)
                homeModuleFacade.navigate(this@MainActivity)
                finish()
            }
        }
    }
}