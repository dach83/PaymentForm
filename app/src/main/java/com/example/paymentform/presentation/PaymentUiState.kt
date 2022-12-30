package com.example.paymentform.presentation

import androidx.annotation.StringRes

data class PaymentUiState(
    val sum: String = "",
    @StringRes val sumError: Int? = null,

    val cardNumber: String = "",
    @StringRes val cardNumberError: Int? = null,

    val submitted: Boolean = false
)
