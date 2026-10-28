package com.reza.crypto.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.crypto.core.common.result.onError
import com.reza.crypto.core.common.result.onSuccess
import com.reza.crypto.core.data.repository.CoinRepository
import com.reza.crypto.core.data.repository.DefaultCoinRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CoinRepository = DefaultCoinRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCoins()
    }

    fun loadCoins() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            repository.getCoins()
                .onSuccess { coins ->
                    _uiState.value = HomeUiState.Success(coins = coins)
                }
                .onError { message, _ ->
                    _uiState.value = HomeUiState.Error(message)
                }
        }
    }

    fun onSearchQueryChange(query: String) {
        val currentState = _uiState.value
        if (currentState is HomeUiState.Success) {
            _uiState.update {
                currentState.copy(searchQuery = query)
            }
        }
    }
}
