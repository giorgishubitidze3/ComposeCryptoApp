package com.example.composecryptoapp.presentation.coin_detail

import com.example.composecryptoapp.domain.model.Coin
import com.example.composecryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
