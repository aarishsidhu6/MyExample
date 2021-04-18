package com.example.dsgc.model.api

import com.example.dsgc.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("events?client_id=MjE3NDM3Mzd8MTYxODY3NDc2MS4wMjQ3NTM&per_page=25")
    fun getRepo(@Query("q") query: String ): Call<ApiResponse>
}