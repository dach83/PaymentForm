package com.example.paymentform.domain.util.date

class FakeDateProvider(
    private val year: Int,
    private val month: Int
) : DateProvider {
    override fun currentYear() = year
    override fun currentMonth() = month
}
