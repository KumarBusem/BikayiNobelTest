package com.busem.data.remote

import com.busem.data.common.SafeApiRequest
import com.busem.data.models.PrizesResponse

class RemoteDataSourceImpl : RemoteDataSource, SafeApiRequest() {

    private val service = ServiceProvider.getInstance().create(GithubService::class.java)

    override suspend fun getPrizes(): PrizesResponse? {
        return apiRequest { service.getNobelPrizes() }
    }

}