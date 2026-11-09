package com.reza.crypto.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// TODO change it based on
data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: Double,
    val changePercent24Hr: Double,
    val marketCapUsd: Double,
    val volumeUsd24Hr: Double
)

@Serializable
data class CryptoCurrencyDto(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    @SerialName("current_price")
    val currentPrice: Double,
    @SerialName("market_cap")
    val marketCap: Long,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("fully_diluted_valuation")
    val fullyDilutedValuation: Long?,
    @SerialName("total_volume")
    val totalVolume: Double,
    @SerialName("high_24h")
    val high24h: Double,
    @SerialName("low_24h")
    val low24h: Double,
    @SerialName("price_change_24h")
    val priceChange24h: Double,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerialName("circulating_supply")
    val circulatingSupply: Double,
    @SerialName("total_supply")
    val totalSupply: Double?,
    @SerialName("max_supply")
    val maxSupply: Double?,
    val ath: Double,
    @SerialName("ath_change_percentage")
    val athChangePercentage: Double,
    @SerialName("ath_date")
    val athDate: String,
    val atl: Double,
    @SerialName("atl_change_percentage")
    val atlChangePercentage: Double,
    @SerialName("atl_date")
    val atlDate: String,
    val roi: RoiDto?,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("market_cap_rank_with_rehypothecated")
    val marketCapRankWithRehypothecated: Int?,
    @SerialName("sparkline_in_7d")
    val sparklineIn7d: SparklineDto?,
    @SerialName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: Double?,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: Double?,
    @SerialName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: Double?,
    @SerialName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: Double?,
    @SerialName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: Double?,
    @SerialName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: Double?,
    @SerialName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: Double?
)

@Serializable
data class RoiDto(
    val times: Double,
    val currency: String,
    val percentage: Double
)

@Serializable
data class SparklineDto(
    val price: List<Double>
)
