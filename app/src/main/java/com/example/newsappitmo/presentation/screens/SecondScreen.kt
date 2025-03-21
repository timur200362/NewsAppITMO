package com.example.newsappitmo.presentation.screens

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable
fun SecondScreen(
    onNavigateToProfile: () -> Unit
) {
    Button(onClick = { onNavigateToProfile() }) {
        Text("Вернуться на главный экран")
    }
}