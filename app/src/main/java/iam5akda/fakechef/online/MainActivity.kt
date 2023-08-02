package iam5akda.fakechef.online

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import iam5akda.fakechef.feature.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

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
                delay(1500L)
                HomeActivity.navigate(this@MainActivity)
                finish()
            }
        }
    }
}