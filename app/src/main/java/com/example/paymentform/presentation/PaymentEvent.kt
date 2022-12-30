package com.example.paymentform.presentation

sealed class PaymentEvent {
    data class ChangeSum(val sum: String) : PaymentEvent()
    data class ChangeCardNumber(val number: String) : PaymentEvent()
    data class ChangeExpirationDate(val date: String) : PaymentEvent()
    data class ChangeCVV(val cvv: String) : PaymentEvent()
    object Submit : PaymentEvent()
}
