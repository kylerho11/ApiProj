package com.example.apiproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
        private const val baseUrl = "https://www.balldontlie.io/api/v1/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }