package com.busem.data.common

import android.util.Log
import com.busem.data.models.PrizesResponse
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>?): T? {
        val response = call.invoke()
        Log.e("Safe API Request::", response.toString())
        return if (response?.isSuccessful!!) response.body()!!
        else null

    }

}
