package com.example.paymentform.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ValidText(isValid: Boolean) {
    if (isValid) {
        Text(
            text = "Valid",
            color = Color.Green,
            style = MaterialTheme.typography.titleLarge
        )
    } else {
        Text(
            text = "Invalid",
            color = Color.Red,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
