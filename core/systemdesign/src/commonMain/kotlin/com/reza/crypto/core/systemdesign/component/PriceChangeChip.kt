package com.reza.crypto.core.systemdesign.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.reza.crypto.core.systemdesign.theme.CryptoGreen
import com.reza.crypto.core.systemdesign.theme.CryptoRed

@Composable
fun PriceChangeChip(
    percentChange: Double,
    modifier: Modifier = Modifier
) {
    val isPositive = percentChange >= 0
    val color = if (isPositive) CryptoGreen else CryptoRed
    val sign = if (isPositive) "+" else ""
    val text = "$sign$percentChange%"

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color.copy(alpha = 0.15f))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )
    }
}
