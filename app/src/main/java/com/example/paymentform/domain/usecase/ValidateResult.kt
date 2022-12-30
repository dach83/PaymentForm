package com.example.paymentform.domain.usecase

import androidx.annotation.StringRes

data class ValidateResult(
    val valid: Boolean,
    @StringRes val error: Int? = null
)
