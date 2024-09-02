package com.example.composecryptoapp.domain.repository

import com.example.composecryptoapp.data.remote.dto.CoinDetailDto
import com.example.composecryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}