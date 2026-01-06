package com.example.androiddemo.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(onClick: () -> Unit, text: String) {

    ElevatedButton(onClick = onClick, modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()) {
        Text(text = text)
    }
}
