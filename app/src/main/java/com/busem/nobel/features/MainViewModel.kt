package com.busem.nobel.features

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.busem.data.models.Prize
import com.busem.data.repositories.DataSourceNobelRepo
import com.busem.data.repositories.NobelRepo
import com.busem.nobel.common.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(
    private val nobelRepo: DataSourceNobelRepo = NobelRepo()
): BaseViewModel() {

    private val _prizeList by lazy { MutableLiveData<List<Prize>>() }
    val prizelist: LiveData<List<Prize>> by lazy { _prizeList }

    init {
        getNobelPrizes()
    }

    private fun getNobelPrizes(){

        ioScope.launch {

            doWhileLoading {

                _prizeList.postValue(nobelRepo.getNobelPrizes())

            }

        }

    }

}