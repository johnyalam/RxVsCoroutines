package fi.developer.rxvscoroutines.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
    @Inject
    constructor() : ViewModel() {
        private val disposables = CompositeDisposable()

        // Coroutine State
        private val _number = MutableStateFlow(0)
        val number: StateFlow<Int> = _number

        // RxJava State
        private val _numberRxJava = MutableStateFlow(0)
        val numberRxJava: StateFlow<Int> = _numberRxJava

        init {
            startRxJavaCounter()
            startCoroutineCounter()
        }

        private fun startCoroutineCounter() {
            viewModelScope.launch {
                for (i in 1..100) {
                    _number.value = i
                    delay(DELAY_IN_MILLISECOND)
                }
            }
        }

        private fun startRxJavaCounter() {
            val disposable =
                Observable
                    .interval(1, TimeUnit.SECONDS)
                    .map {
                        it.toInt() + 1
                    }.take(DELAY_IN_MILLISECOND)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        _numberRxJava.value = it
                    }
            disposables.add(disposable)
        }

        override fun onCleared() {
            disposables.clear()
            super.onCleared()
        }

        companion object {
            const val DELAY_IN_MILLISECOND = 1000L
        }
    }
