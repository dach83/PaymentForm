package com.example.paymentform.domain.util.date

import java.util.*

class CurrentDateProvider : DateProvider {
    override fun currentYear() = Calendar.getInstance()
        .get(Calendar.YEAR)

    override fun currentMonth() = Calendar.getInstance()
        .get(Calendar.MONTH)
}
