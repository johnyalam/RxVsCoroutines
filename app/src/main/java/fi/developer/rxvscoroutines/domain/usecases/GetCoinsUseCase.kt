package fi.developer.rxvscoroutines.domain.usecases

import fi.developer.rxvscoroutines.core.Resource
import fi.developer.rxvscoroutines.domain.model.CoinItem
import fi.developer.rxvscoroutines.domain.repository.CoinRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetCoinsUseCase
    @Inject
    constructor(
        private val repository: CoinRepository,
    ) {
        operator fun invoke(): Observable<Resource<List<CoinItem>>> =
            repository
                .getCoins()
                .toObservable()
                .map<Resource<List<CoinItem>>> { coins ->
                    Resource.Success(coins)
                }.onErrorReturn { error ->
                    Resource.Error(error.message ?: "Unknown error")
                }.startWithItem(Resource.Loading())
    }
