package com.busem.data.remote

import com.busem.data.models.PrizesResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * Remote service to fetch for the repositories list.
 */
interface GithubService {

    @GET("/v1/prize.json")
    suspend fun getNobelPrizes(): Response<PrizesResponse>

}

