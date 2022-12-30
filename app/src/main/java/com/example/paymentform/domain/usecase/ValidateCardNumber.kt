package com.example.paymentform.domain.usecase

import androidx.core.text.isDigitsOnly
import com.example.paymentform.R

class ValidateCardNumber {
    operator fun invoke(cardNumber: String): ValidateResult {
        val input = cardNumber.replace(" ", "")

        // for simplicity, check that the card number consists of 16 digits
        if (input.length != CARD_NUMBER_LENGTH || !input.isDigitsOnly()) {
            return ValidateResult(
                valid = false,
                error = R.string.incorrect_card_number
            )
        }
        return ValidateResult(valid = true)
    }

    companion object {
        private const val CARD_NUMBER_LENGTH = 16
    }
}
