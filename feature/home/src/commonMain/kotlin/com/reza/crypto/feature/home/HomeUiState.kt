package com.reza.crypto.feature.home

import com.reza.crypto.core.data.model.Coin

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(
        val coins: List<Coin>,
        val searchQuery: String = ""
    ) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
