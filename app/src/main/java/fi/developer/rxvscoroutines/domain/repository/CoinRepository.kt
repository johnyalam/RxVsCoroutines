package fi.developer.rxvscoroutines.domain.repository

import fi.developer.rxvscoroutines.domain.model.CoinItem

interface CoinRepository {
    suspend fun getCoins(): List<CoinItem>
}
