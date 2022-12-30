package com.example.paymentform.presentation

import com.example.paymentform.R
import org.junit.Assert.*
import org.junit.Test

class PaymentViewModelTest {

    @Test
    fun zero_payment_sum() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeSum("0"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.enter_a_positive_non_zero_number, sut.uiState.sumError)
    }

    @Test
    fun negative_payment_sum() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeSum("-100"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.enter_a_positive_non_zero_number, sut.uiState.sumError)
    }

    @Test
    fun too_much_payment_sum() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeSum("99999999999999999"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.payment_amount_is_too_large, sut.uiState.sumError)
    }

    @Test
    fun incorrect_card_number() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeCardNumber("0001 322 4534 2333"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.incorrect_card_number, sut.uiState.cardNumberError)
    }

    @Test
    fun incorrect_month_in_expiration_date() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeExpirationDate("15/29"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.incorrect_expiration_date, sut.uiState.expirationDateError)
    }

    @Test
    fun incorrect_year_in_expiration_date() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeExpirationDate("08/19"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.incorrect_expiration_date, sut.uiState.expirationDateError)
    }
}
