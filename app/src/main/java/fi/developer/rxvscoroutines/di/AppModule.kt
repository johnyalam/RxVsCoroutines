package fi.developer.rxvscoroutines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fi.developer.rxvscoroutines.core.Constants.BASE_URL
import fi.developer.rxvscoroutines.data.remote.NetworkApi
import fi.developer.rxvscoroutines.domain.repository.CoinRepository
import fi.developer.rxvscoroutines.domain.repository.CoinRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun networkInstance(): NetworkApi {
        val retrofitIns =
            Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkApi::class.java)

        return retrofitIns
    }

    @Provides
    @Singleton
    fun provideCoinRepository(networkApi: NetworkApi): CoinRepository = CoinRepositoryImpl(networkApi)
}
