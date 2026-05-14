package fi.developer.rxvscoroutines.domain.repository

import fi.developer.rxvscoroutines.domain.model.CoinItem
import io.reactivex.rxjava3.core.Single

interface CoinRepository {
    fun getCoins(): Single<List<CoinItem>>
}
