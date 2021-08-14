package com.busem.data.repositories

import com.busem.data.common.DataState
import com.busem.data.models.Prize
import com.busem.data.models.PrizesResponse
import okhttp3.RequestBody

interface DataSourceNobelRepo {

    suspend fun getNobelPrizes(): List<Prize>?

}