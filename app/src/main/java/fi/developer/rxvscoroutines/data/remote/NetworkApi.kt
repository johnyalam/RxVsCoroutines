package fi.developer.rxvscoroutines.data.remote

import fi.developer.rxvscoroutines.domain.model.CoinItem
import retrofit2.http.GET

interface NetworkApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinItem>
}
