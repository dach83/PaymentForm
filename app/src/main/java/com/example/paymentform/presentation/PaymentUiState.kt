package com.example.paymentform.presentation

import androidx.annotation.StringRes

data class PaymentUiState(
    val sum: String = "",
    @StringRes val sumError: Int? = null,
    val submitted: Boolean = false
)
