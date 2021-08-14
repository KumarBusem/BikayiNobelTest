package com.busem.data.remote

import com.busem.data.models.PrizesResponse
import okhttp3.RequestBody


interface RemoteDataSource {

    suspend fun getPrizes(): PrizesResponse?

}