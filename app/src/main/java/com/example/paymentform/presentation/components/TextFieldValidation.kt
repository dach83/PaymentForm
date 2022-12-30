package com.example.paymentform.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldValidation(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes error: Int? = null,
    label: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxTextLength: Int = 0
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = value,
            onValueChange = {
                val str = if (maxTextLength in 1..it.length) {
                    it.substring(0 until maxTextLength)
                } else {
                    it
                }
                onValueChange(str)
            },
            isError = error != null,
            modifier = modifier,
            label = label,
            singleLine = true,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
        )
        if (error != null) {
            Text(
                text = stringResource(id = error),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp, top = 0.dp),
                textAlign = TextAlign.Start
            )
        }
    }
}
