package iam5akda.fakechef.feature.home.view.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iam5akda.fakechef.core.design.R
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

    private val _appNameStateFlow = MutableStateFlow("")
    val appNameStateFlow: StateFlow<String> = _appNameStateFlow

    fun startAppNameAnimation() = viewModelScope.launch {
        if (_appNameStateFlow.value.isEmpty()) {
            val repetition = savedStateHandle["repetition"] ?: 1
            repository.getAnimatedAppName(repetition)
                .collect {
                    _appNameStateFlow.value = it
                }
        }
    }

    fun getFoodImageResId(): Int {
        return listOf(
            R.drawable.ic_menu_burger,
            R.drawable.ic_menu_pizza,
            R.drawable.ic_menu_ramen,
            R.drawable.ic_menu_nachos
        ).random()
    }
}