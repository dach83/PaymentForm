package com.example.paymentform.presentation

sealed class PaymentEvent {
    class ChangeSum(val sum: String) : PaymentEvent()
    class ChangeCardNumber(val number: String) : PaymentEvent()
    object Submit : PaymentEvent()
}
