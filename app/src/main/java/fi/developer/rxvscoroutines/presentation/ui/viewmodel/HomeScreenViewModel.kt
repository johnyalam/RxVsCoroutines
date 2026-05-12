package fi.developer.rxvscoroutines.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.developer.rxvscoroutines.core.Resource
import fi.developer.rxvscoroutines.domain.usecases.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
    @Inject
    constructor(
        private val getCoinsUseCase: GetCoinsUseCase,
    ) : ViewModel() {
        private val _state = MutableStateFlow(CoinListState())
        val state = _state.asStateFlow()

        init {
            getCoinList()
        }

        fun getCoinList() {
            getCoinsUseCase()
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = CoinListState(data = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            _state.value = CoinListState(error = result.message ?: "An unexpected error occured")
                        }
                        is Resource.Loading -> {
                            _state.value = CoinListState(isLoading = true)
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }
