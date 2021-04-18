package com.example.dsgc.model

import com.example.dsgc.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository {

    // GET repo list
    fun getRepoList(query:String,onResult: (isSuccess: Boolean, response: ApiResponse?) -> Unit) {

        ApiClient.instance.getRepo(query).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>?, response: Response<ApiResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: RepoRepository? = null
        fun getInstance() = INSTANCE
                ?: RepoRepository().also {
                    INSTANCE = it
                }
    }
}