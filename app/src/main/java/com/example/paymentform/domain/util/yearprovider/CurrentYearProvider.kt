package com.example.paymentform.domain.util.yearprovider

import java.util.*

class CurrentYearProvider : YearProvider {
    override fun currentYear(): Int {
        val c = Calendar.getInstance()
        return c.get(Calendar.YEAR)
    }
}
