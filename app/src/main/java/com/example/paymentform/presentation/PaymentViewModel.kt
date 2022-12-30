package com.example.paymentform.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.paymentform.domain.usecase.*

class PaymentViewModel(
    private val validateSum: ValidateSum = ValidateSum(),
    private val validateCardNumber: ValidateCardNumber = ValidateCardNumber(),
    private val validateExpirationDate: ValidateExpirationDate = ValidateExpirationDate(),
    private val validateCvv: ValidateCvv = ValidateCvv()
) : ViewModel() {

    var uiState by mutableStateOf(PaymentUiState())
        private set

    fun onEvent(event: PaymentEvent) = when (event) {
        is PaymentEvent.ChangeSum -> uiState = uiState.copy(
            sum = event.sum,
            sumError = null,
            submitted = false
        )
        is PaymentEvent.ChangeCardNumber -> uiState = uiState.copy(
            cardNumber = event.number,
            cardNumberError = null,
            submitted = false
        )
        is PaymentEvent.ChangeExpirationDate -> uiState = uiState.copy(
            expirationDate = event.date,
            expirationDateError = null,
            submitted = false
        )
        is PaymentEvent.ChangeCVV -> uiState = uiState.copy(
            cvv = event.cvv,
            cvvError = null,
            submitted = false
        )
        PaymentEvent.Submit -> submit()
    }

    private fun submit() {
        val sumResult = validateSum(uiState.sum)
        val cardNumberResult = validateCardNumber(uiState.cardNumber)
        val expirationDateResult = validateExpirationDate(uiState.expirationDate)
        val cvvResult = validateCvv(uiState.cvv)

        val hasError = listOf(
            sumResult,
            cardNumberResult,
            expirationDateResult,
            cvvResult
        ).any {
            it.error != null
        }

        uiState = uiState.copy(
            sumError = sumResult.error,
            cardNumberError = cardNumberResult.error,
            expirationDateError = expirationDateResult.error,
            cvvError = cvvResult.error,
            submitted = !hasError
        )
    }
}
