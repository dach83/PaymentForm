package com.example.paymentform.domain.usecase

import com.example.paymentform.R

class ValidateSum {
    operator fun invoke(sum: String): ValidateResult {
        val value = sum.toDoubleOrNull() ?: 0.0
        if (value < 0.01) {
            return ValidateResult(
                valid = false,
                error = R.string.enter_a_positive_non_zero_number
            )
        }
        if (value > MAX_SUM) {
            return ValidateResult(
                valid = false,
                error = R.string.payment_amount_is_too_large
            )
        }
        return ValidateResult(valid = true)
    }

    companion object {
        private const val MAX_SUM = 1_000_000
    }
}
