package com.reza.crypto.core.data.repository

import com.reza.crypto.core.common.result.AppResult
import com.reza.crypto.core.data.model.Coin

interface CoinRepository {
    suspend fun getCoins(): AppResult<List<Coin>>
    suspend fun getCoinById(id: String): AppResult<Coin>
}
