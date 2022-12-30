package com.example.paymentform.domain.usecase

import com.example.paymentform.R
import com.example.paymentform.domain.util.date.CurrentDateProvider
import com.example.paymentform.domain.util.date.DateProvider

class ValidateExpirationDate(
    private val dateProvider: DateProvider = CurrentDateProvider()
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
        val (month, year) = expirationDate
            .split("/")
            .map { it.toIntOrNull() }

        if (month == null || month < 1 || month > 12 ||
            year == null || year < 1 ||
            dateIsExpired(month, year)
        ) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_expiration_date
            )
        }
        return ValidateResult(valid = true)
    }

    private fun dateIsExpired(month: Int, year: Int): Boolean {
        val currentMonth = dateProvider.currentMonth()
        val currentYear = dateProvider.currentYear() % 100 // only last two digits of year
        return monthsAt(year, month) < monthsAt(currentYear, currentMonth)
    }

    private fun monthsAt(year: Int, month: Int) = year * 12 + month
}
