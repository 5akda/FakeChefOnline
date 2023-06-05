package iam5akda.fakechef.feature.home.view.menu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {

    val animationStateFlow: StateFlow<String> = MutableStateFlow("Fake Chef")
}