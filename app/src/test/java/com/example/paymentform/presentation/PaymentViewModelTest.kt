package com.example.paymentform.presentation

import com.example.paymentform.R
import org.junit.Assert.*
import org.junit.Test

class PaymentViewModelTest {

    @Test
    fun zero_sum_payment() {
        // arrange
        val sut = PaymentViewModel()
        sut.onEvent(PaymentEvent.ChangeSum("0"))

        // act
        sut.onEvent(PaymentEvent.Submit)

        // assert
        assertEquals(false, sut.uiState.submitted)
        assertEquals(R.string.enter_a_positive_non_zero_number, sut.uiState.sumError)
    }
}
