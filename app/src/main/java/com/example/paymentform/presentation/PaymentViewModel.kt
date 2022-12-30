package com.example.paymentform.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.paymentform.domain.usecase.ValidateCardNumber
import com.example.paymentform.domain.usecase.ValidateExpirationDate
import com.example.paymentform.domain.usecase.ValidateSum

class PaymentViewModel(
    private val validateSum: ValidateSum = ValidateSum(),
    private val validateCardNumber: ValidateCardNumber = ValidateCardNumber(),
    private val validateExpirationDate: ValidateExpirationDate = ValidateExpirationDate(),
) {

    var uiState by mutableStateOf(PaymentUiState())
        private set

    fun onEvent(event: PaymentEvent) = when (event) {
        is PaymentEvent.ChangeSum -> uiState = uiState.copy(sum = event.sum)
        is PaymentEvent.ChangeCardNumber -> uiState = uiState.copy(cardNumber = event.number)
        is PaymentEvent.ChangeExpirationDate -> uiState = uiState.copy(expirationDate = event.date)
        PaymentEvent.Submit -> submit()
    }

    private fun submit() {
        val sumResult = validateSum(uiState.sum)
        val cardNumberResult = validateCardNumber(uiState.cardNumber)
        val expirationDateResult = validateExpirationDate(uiState.expirationDate)

        val hasError = listOf(
            sumResult,
            cardNumberResult,
            expirationDateResult
        ).any {
            it.error != null
        }

        if (hasError) {
            uiState = uiState.copy(
                sumError = sumResult.error,
                cardNumberError = cardNumberResult.error,
                expirationDateError = expirationDateResult.error
            )
        }
    }
}
