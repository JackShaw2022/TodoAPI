package com.example.TodoAPI_jan10.model.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory
                    .create(
                        Moshi.Builder()
                            .build()
                    )
            )
            .build()
    }

}