package com.reza.crypto.core.network.di

import com.reza.crypto.core.network.BuildConfig
import com.reza.crypto.core.network.NetworkConfig
import org.koin.dsl.module

val networkModule = module {
    single<NetworkConfig> {
        NetworkConfig(
            baseUrl = BuildConfig.BASE_URL,
            apiKey = BuildConfig.API_KEY,
        )
    }
}
