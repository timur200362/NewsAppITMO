package com.example.newsappitmo.presentation.screens

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsappitmo.presentation.mvvm.NewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = koinViewModel(),
    context: Context = LocalContext.current
) {
    var query by remember { mutableStateOf("") }
    val news by viewModel.news.observeAsState()

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = query,
            onValueChange = {newQuery -> query = newQuery},
            label = { Text("Введите запрос...") },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            if (news?.status == "ok") {
                items(news?.articles ?: emptyList()) { article ->
//                    AsyncImage(
//                        model = article.urlToImage,
//                        contentDescription = null
//                    )
                    Text(article.title, fontWeight = FontWeight.Bold)
                    Text(article.title)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (query.isBlank()) {
                    Toast.makeText(context, "Введите запрос!", Toast.LENGTH_SHORT).show()
                } else if (!isOnline(context)) {
                    Toast.makeText(context, "Проверьте подключение к интернету!", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.getNews(query)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Поиск") }
    }
}

fun isOnline(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkCapabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
}