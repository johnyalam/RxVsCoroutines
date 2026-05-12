package fi.developer.rxvscoroutines.presentation.ui.viewmodel

import fi.developer.rxvscoroutines.domain.model.CoinResponseItem

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<CoinResponseItem> = emptyList(),
    val error: String = "",
)
