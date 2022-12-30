package com.example.paymentform.domain.usecase

import com.example.paymentform.R

class ValidateSum {
    operator fun invoke(sum: String): ValidateResult {
        val value = sum.toDoubleOrNull() ?: 0.0
        if (value <= 0.0) {
            return ValidateResult(
                valid = false,
                error = R.string.enter_a_positive_non_zero_number
            )
        }

        return ValidateResult(valid = true)
    }
}
