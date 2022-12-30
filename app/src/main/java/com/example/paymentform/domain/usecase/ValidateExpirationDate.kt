package com.example.paymentform.domain.usecase

import com.example.paymentform.R
import com.example.paymentform.domain.util.yearprovider.CurrentYearProvider
import com.example.paymentform.domain.util.yearprovider.YearProvider

class ValidateExpirationDate(
    private val yearProvider: YearProvider = CurrentYearProvider()
) {
    operator fun invoke(expirationDate: String): ValidateResult {
        if (!expirationDate.contains("/")) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }

        // expect that the expiration date came here in
        // the month/year format, for example 08/29
        val (month, year) = expirationDate.split("/").map { it.toIntOrNull() }

        if (month == null || month < 1 || month > 12) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }

        val currentYear = yearProvider.currentYear() % 100 // last 2 digits of year
        if (year == null || year < currentYear) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }

        return ValidateResult(valid = true)
    }
}
