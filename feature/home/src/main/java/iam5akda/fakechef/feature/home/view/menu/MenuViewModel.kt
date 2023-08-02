package iam5akda.fakechef.feature.home.view.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iam5akda.fakechef.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    repository: HomeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val animationRepetition: Int by lazy {
        savedStateHandle["repetition"] ?: 1
    }

    val animationStateFlow: StateFlow<String> = repository
        .getAnimatedAppName(animationRepetition)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = ""
        )
}