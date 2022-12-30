package com.example.paymentform.domain.util.yearprovider

class FakeYearProvider(private val year: Int) : YearProvider {
    override fun currentYear(): Int {
        return year
    }
}
