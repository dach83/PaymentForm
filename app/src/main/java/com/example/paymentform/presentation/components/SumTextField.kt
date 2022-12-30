package com.example.paymentform.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.paymentform.R
import com.example.paymentform.presentation.components.TextFieldValidation

@Composable
fun SumTextField(
    uiState: PaymentUiState,
    onValueChange: (String) -> Unit
) {
    TextFieldValidation(
        value = uiState.sum,
        error = uiState.sumError,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = stringResource(id = R.string.amount_of_money))
        },
        maxTextLength = 12
    )
}
