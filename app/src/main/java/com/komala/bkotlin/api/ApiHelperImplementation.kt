package com.komala.bkotlin.api

import retrofit2.Response
import javax.inject.Inject

class ApiHelperImplementation @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }
}