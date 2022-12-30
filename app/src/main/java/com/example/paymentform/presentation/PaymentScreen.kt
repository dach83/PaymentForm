package com.example.paymentform.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.paymentform.presentation.components.CreditCard
import com.example.paymentform.presentation.components.ValidText

@Composable
fun PaymentScreen(viewModel: PaymentViewModel = viewModel()) {
    val uiState = viewModel.uiState
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SumTextField(
            uiState,
            onValueChange = {
                viewModel.onEvent(PaymentEvent.ChangeSum(it))
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        CreditCard(
            uiState,
            onCardNumberChange = {
                viewModel.onEvent(PaymentEvent.ChangeCardNumber(it))
            },
            onExpirationDateChange = {
                viewModel.onEvent(PaymentEvent.ChangeExpirationDate(it))
            },
            onCvvChange = {
                viewModel.onEvent(PaymentEvent.ChangeCVV(it))
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        ValidText(uiState.submitted)
        Spacer(modifier = Modifier.height(32.dp))
        PayButton(
            onClick = {
                viewModel.onEvent(PaymentEvent.Submit)
            }
        )
    }
}
