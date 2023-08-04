package iam5akda.fakechef.feature.home.view.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iam5akda.fakechef.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _appName = MutableStateFlow("")
    val appName: StateFlow<String> = _appName

    /*
    val animationStateFlow: StateFlow<String> = repository
        .getAnimatedAppName(savedStateHandle["repetition"] ?: 1)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = ""
        )
     */

    fun startAppNameAnimation() = viewModelScope.launch {
        if (_appName.value.isEmpty()) {
            val repetition = savedStateHandle["repetition"] ?: 1
            repository.getAnimatedAppName(repetition)
                .collect {
                    _appName.value = it
                }
        }
    }
}