package com.reza.crypto.core.common.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
