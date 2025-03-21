package com.example.newsappitmo.data.remote.response

import com.google.gson.annotations.SerializedName

data class NewsResponse (
	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)