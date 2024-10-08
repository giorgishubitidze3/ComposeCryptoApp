package com.example.composecryptoapp.domain.use_case.get_coin

import com.example.composecryptoapp.common.Resource
import com.example.composecryptoapp.data.remote.dto.toCoin
import com.example.composecryptoapp.data.remote.dto.toCoinDetail
import com.example.composecryptoapp.domain.model.Coin
import com.example.composecryptoapp.domain.model.CoinDetail
import com.example.composecryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try{
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch(e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }
        catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}