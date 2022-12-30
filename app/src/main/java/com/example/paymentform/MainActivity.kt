package com.example.paymentform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.paymentform.presentation.PaymentScreen
import com.example.paymentform.ui.theme.PaymentFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentFormTheme {
                PaymentScreen()
            }
        }
    }
}
