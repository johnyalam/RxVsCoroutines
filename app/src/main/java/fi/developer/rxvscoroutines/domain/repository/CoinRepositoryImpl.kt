package fi.developer.rxvscoroutines.domain.repository

import fi.developer.rxvscoroutines.data.remote.NetworkApi
import fi.developer.rxvscoroutines.domain.model.CoinItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CoinRepositoryImpl
    @Inject
    constructor(
        val networkApi: NetworkApi,
    ) : CoinRepository {
        override fun getCoins(): Single<List<CoinItem>> = networkApi.getCoins()
    }
