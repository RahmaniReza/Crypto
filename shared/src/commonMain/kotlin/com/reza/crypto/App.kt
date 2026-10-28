package com.reza.crypto

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.reza.crypto.core.systemdesign.theme.CryptoTheme
import com.reza.crypto.feature.home.HomeScreen

@Composable
@Preview
fun App() {
    CryptoTheme {
        HomeScreen()
    }
}
