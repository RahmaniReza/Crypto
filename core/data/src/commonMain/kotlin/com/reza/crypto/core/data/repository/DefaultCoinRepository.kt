package com.reza.crypto.core.data.repository

import com.reza.crypto.core.common.result.AppResult
import com.reza.crypto.core.data.model.Coin

class DefaultCoinRepository : CoinRepository {
    private val sampleCoins = listOf(
        Coin(
            id = "bitcoin",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            priceUsd = 67450.25,
            changePercent24Hr = 2.45,
            marketCapUsd = 1320000000000.0,
            volumeUsd24Hr = 32500000000.0
        ),
        Coin(
            id = "ethereum",
            name = "Ethereum",
            symbol = "ETH",
            rank = 2,
            priceUsd = 3480.80,
            changePercent24Hr = -1.12,
            marketCapUsd = 418000000000.0,
            volumeUsd24Hr = 18900000000.0
        ),
        Coin(
            id = "solana",
            name = "Solana",
            symbol = "SOL",
            rank = 3,
            priceUsd = 175.60,
            changePercent24Hr = 5.84,
            marketCapUsd = 82000000000.0,
            volumeUsd24Hr = 4800000000.0
        ),
        Coin(
            id = "cardano",
            name = "Cardano",
            symbol = "ADA",
            rank = 4,
            priceUsd = 0.48,
            changePercent24Hr = 1.05,
            marketCapUsd = 17200000000.0,
            volumeUsd24Hr = 520000000.0
        ),
        Coin(
            id = "ripple",
            name = "XRP",
            symbol = "XRP",
            rank = 5,
            priceUsd = 0.58,
            changePercent24Hr = -0.65,
            marketCapUsd = 32500000000.0,
            volumeUsd24Hr = 1200000000.0
        )
    )

    override suspend fun getCoins(): AppResult<List<Coin>> {
        return AppResult.Success(sampleCoins)
    }

    override suspend fun getCoinById(id: String): AppResult<Coin> {
        val coin = sampleCoins.find { it.id == id }
        return if (coin != null) {
            AppResult.Success(coin)
        } else {
            AppResult.Error("Coin not found: $id")
        }
    }
}
