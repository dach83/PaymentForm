package com.example.paymentform.presentation.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

// Format card number in 1111-2222-3333-4444
fun formatCardNumber(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 16) {
        text.text.substring(0..15)
    } else {
        text.text
    }

    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i != 15) out += " "
    }

    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 7) return offset + 1
            if (offset <= 11) return offset + 2
            if (offset <= 16) return offset + 3
            return 19
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 9) return offset - 1
            if (offset <= 14) return offset - 2
            if (offset <= 19) return offset - 3
            return 16
        }
    }

    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}

// Format expiration date in 12/23
fun formatExpirationDate(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 4) {
        text.text.substring(0..3)
    } else {
        text.text
    }

    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i != 3) out += "/"
    }

    val expirationDateOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset + 1
            return 5
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset - 1
            return 4
        }
    }

    return TransformedText(AnnotatedString(out), expirationDateOffsetTranslator)
}
