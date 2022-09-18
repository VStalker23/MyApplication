package com.vladimirorlov.myapplication

import com.google.gson.annotations.SerializedName

data class ApiImage(@SerializedName("webformatURL") val imageUrl:String)

data class ApiResponseHitsList(@SerializedName("hits") val imagesList:List<ApiImage>)