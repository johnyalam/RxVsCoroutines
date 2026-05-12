package fi.developer.rxvscoroutines.presentation.ui.viewmodel

import fi.developer.rxvscoroutines.domain.model.CoinItem

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<CoinItem> = emptyList(),
    val error: String = "",
)
