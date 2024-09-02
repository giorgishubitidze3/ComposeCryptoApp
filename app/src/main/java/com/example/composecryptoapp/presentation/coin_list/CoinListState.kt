package com.example.composecryptoapp.presentation.coin_list

import com.example.composecryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
