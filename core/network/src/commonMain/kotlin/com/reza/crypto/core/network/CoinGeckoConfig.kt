package com.reza.crypto.core.network

/**
 * Configuration holder for network requests.
 * By default, values are populated from [BuildConfig].
 */
data class NetworkConfig(
    val baseUrl: String = BuildConfig.BASE_URL,
    val apiKey: String = BuildConfig.API_KEY,
)

/**
 * Protocol-level constants that do not vary across environments.
 */
object NetworkConstants {
    const val HEADER_API_KEY = "x-cg-demo-api-key"
    const val PARAM_API_KEY = "x_cg_demo_api_key"
}
