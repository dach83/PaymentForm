package com.example.paymentform.domain.usecase

import com.example.paymentform.R

class ValidateExpirationDate {
    operator fun invoke(expirationDate: String): ValidateResult {
        if (!expirationDate.contains("/")) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }

        // expect that the expiration date came here in
        // the month/year format, for example 08/29
        val (month, year) = expirationDate
            .split("/")
            .map { it.toIntOrNull() }

        if (month == null || month < 1 || month > 12) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }
        return ValidateResult(valid = true)
    }
}
