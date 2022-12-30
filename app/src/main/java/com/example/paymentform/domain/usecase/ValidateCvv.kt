package com.example.paymentform.domain.usecase

import com.example.paymentform.R

class ValidateCvv {
    operator fun invoke(cvv: String): ValidateResult {
        if (cvv.length != CVV_LENGTH || !cvv.all { it.isDigit() }) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_cvv
            )
        }
        return ValidateResult(valid = true)
    }

    companion object {
        private const val CVV_LENGTH = 3
    }
}
