package com.example.newsappitmo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newsappitmo.presentation.screens.NewsScreen
import com.example.newsappitmo.ui.theme.NewsAppITMOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppITMOTheme {
                Surface(modifier = Modifier.Companion.fillMaxSize()) {
                    NewsScreen()
                }
            }
        }
    }
}