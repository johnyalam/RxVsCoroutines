package fi.developer.rxvscoroutines.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.developer.rxvscoroutines.core.Resource
import fi.developer.rxvscoroutines.domain.usecases.GetCoinsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
    @Inject
    constructor(
        private val getCoinsUseCase: GetCoinsUseCase,
    ) : ViewModel() {
        private val _state = MutableStateFlow(CoinListState())
        val state = _state.asStateFlow()

        val disposables = CompositeDisposable()

        init {
            getCoinList()
        }

        fun getCoinList() {
            val disposable =
                getCoinsUseCase()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { result ->
                        when (result) {
                            is Resource.Success -> {
                                _state.value = CoinListState(data = result.data ?: emptyList())
                            }
                            is Resource.Error -> {
                                _state.value = CoinListState(error = result.message ?: "An unexpected error occurred")
                            }
                            is Resource.Loading -> {
                                _state.value = CoinListState(isLoading = true)
                            }
                        }
                    }
            disposables.add(disposable)
        }

        override fun onCleared() {
            super.onCleared()
            disposables.clear()
        }
    }
