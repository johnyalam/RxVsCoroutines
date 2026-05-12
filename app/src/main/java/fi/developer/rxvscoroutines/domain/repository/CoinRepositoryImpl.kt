package fi.developer.rxvscoroutines.domain.repository

import fi.developer.rxvscoroutines.data.remote.NetworkApi
import fi.developer.rxvscoroutines.domain.model.CoinResponseItem
import javax.inject.Inject

class CoinRepositoryImpl
    @Inject
    constructor(
        val networkApi: NetworkApi,
    ) : CoinRepository {
        override suspend fun getCoins(): List<CoinResponseItem> = networkApi.getCoins()
    }
