package com.example.nytbestsellersapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BooksApiService {
    @GET("lists/current/hardcover-fiction.json")
    fun getBestSellers(): Call<BookResponse>

    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"
        fun create(): BooksApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BooksApiService::class.java)
        }
    }
}
