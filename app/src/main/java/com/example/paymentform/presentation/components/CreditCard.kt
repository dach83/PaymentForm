package com.example.paymentform.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.paymentform.R
import com.example.paymentform.presentation.PaymentUiState
import com.example.paymentform.presentation.util.formatCardNumber
import com.example.paymentform.presentation.util.formatExpirationDate

@Composable
fun CreditCard(
    uiState: PaymentUiState,
    onCardNumberChange: (String) -> Unit = {},
    onExpirationDateChange: (String) -> Unit = {},
    onCvvChange: (String) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.card),
                style = MaterialTheme.typography.titleLarge
            )
            TextFieldValidation(
                value = uiState.cardNumber,
                error = uiState.cardNumberError,
                onValueChange = onCardNumberChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.card_number))
                },
                visualTransformation = {
                    formatCardNumber(it)
                },
                maxTextLength = 16
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                TextFieldValidation(
                    value = uiState.expirationDate,
                    error = uiState.expirationDateError,
                    onValueChange = onExpirationDateChange,
                    modifier = Modifier.width(120.dp),
                    label = {
                        Text(text = stringResource(id = R.string.MM_YY))
                    },
                    visualTransformation = {
                        formatExpirationDate(it)
                    },
                    maxTextLength = 4
                )
                Spacer(modifier = Modifier.width(16.dp))
                TextFieldValidation(
                    value = uiState.cvv,
                    error = uiState.cvvError,
                    onValueChange = onCvvChange,
                    modifier = Modifier.width(120.dp),
                    label = {
                        Text(text = stringResource(id = R.string.cvv))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    visualTransformation = PasswordVisualTransformation(),
                    maxTextLength = 3
                )
            }
        }
    }
}
