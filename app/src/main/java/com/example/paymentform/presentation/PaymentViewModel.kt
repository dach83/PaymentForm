package com.example.paymentform.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.paymentform.domain.usecase.ValidateSum

class PaymentViewModel(
    private val validateSum: ValidateSum = ValidateSum()
) {

    var uiState by mutableStateOf(PaymentUiState())
        private set

    fun onEvent(event: PaymentEvent) = when (event) {
        is PaymentEvent.ChangeSum -> uiState = uiState.copy(sum = event.sum)
        PaymentEvent.Submit -> submit()
    }

    private fun submit() {
        val sumResult = validateSum(uiState.sum)

        val hasError = sumResult.error != null
        if (hasError) {
            uiState = uiState.copy(
                sumError = sumResult.error
            )
        }
    }
}
