package com.example.paymentform.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.paymentform.R

@Composable
fun PayButton(
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = stringResource(id = R.string.pay))
    }
}
