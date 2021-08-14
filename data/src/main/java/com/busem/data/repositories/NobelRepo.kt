package com.busem.data.repositories

import com.busem.data.models.Prize
import com.busem.data.remote.RemoteDataSource
import com.busem.data.remote.RemoteDataSourceImpl
import com.busem.data.repositories.DataSourceNobelRepo
import okhttp3.RequestBody

class NobelRepo : DataSourceNobelRepo {

    private val remote: RemoteDataSource by lazy { RemoteDataSourceImpl() }

    override suspend fun getNobelPrizes(): List<Prize>? {

        //LOGIC TO STORE IN ROOM
        return remote.getPrizes()?.prizes

    }
}