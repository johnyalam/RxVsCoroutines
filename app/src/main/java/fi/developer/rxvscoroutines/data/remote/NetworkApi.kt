package fi.developer.rxvscoroutines.data.remote

import fi.developer.rxvscoroutines.domain.model.CoinItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface NetworkApi {
    @GET("/v1/coins")
    fun getCoins(): Single<List<CoinItem>>
}
