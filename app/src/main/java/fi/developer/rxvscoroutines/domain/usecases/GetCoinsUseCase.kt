package fi.developer.rxvscoroutines.domain.usecases

import fi.developer.rxvscoroutines.core.Resource
import fi.developer.rxvscoroutines.domain.model.CoinItem
import fi.developer.rxvscoroutines.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinsUseCase
    @Inject
    constructor(
        private val coinRepository: CoinRepository,
    ) {
        operator fun invoke(): Flow<Resource<List<CoinItem>>> =
            flow {
                try {
                    emit(Resource.Loading())
                    val coins = coinRepository.getCoins()
                    emit(Resource.Success(coins))
                } catch (error: IOException) {
                    emit(Resource.Error("Couldn't reach server. Check your internet connection."))
                }
            }
    }
