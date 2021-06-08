package com.komala.bkotlin.api

import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}