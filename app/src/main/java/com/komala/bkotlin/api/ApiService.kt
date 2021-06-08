package com.komala.bkotlin.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}