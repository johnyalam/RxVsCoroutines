package fi.developer.rxvscoroutines.domain.repository

import fi.developer.rxvscoroutines.domain.model.CoinResponseItem

interface CoinRepository {
    suspend fun getCoins(): List<CoinResponseItem>
}
