package com.busem.nobel.features

import android.util.Log
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.busem.data.models.Prize
import com.busem.nobel.common.BaseActivity
import com.busem.nobel.common.ViewModelFactory
import com.busem.nobel.common.searchWordsFilter
import com.busem.nobel.databinding.ActivityMainBinding


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private var prizesList: List<Prize> = emptyList()
    private val nobelAdapter by lazy { NobelAdapter(::onSelected) }

    override fun setViewModel(): MainViewModel =
        ViewModelProvider(this@MainActivity, ViewModelFactory {
            MainViewModel()
        }).get(MainViewModel::class.java)


    override fun setupViews(): ActivityMainBinding.() -> Unit = {

        fun setupNobelList() {
            rvNobelList.apply {
                adapter = nobelAdapter
            }
        }

        fun setupSearch(){
            etSearch.doOnTextChanged { text, _, _, _ ->

                val filter = text?.toString()
                if (filter.isNullOrEmpty())
                    nobelAdapter.submitList(prizesList)
                else {
                    nobelAdapter.submitList(prizesList.filter {
                        it.toString().searchWordsFilter(filter)
                    })

                }
            }
        }

        setupSearch()
        setupNobelList()
    }

    override fun setupObservers(): MainViewModel.() -> Unit = {

        viewModel.prizelist.observe(this@MainActivity){ list->

            Log.e("LIST::", list.toString())

            nobelAdapter.submitList(list)

            prizesList = list

        }

    }


    private fun onSelected(prize: Prize) {
        Toast.makeText(this, prize.laureates[0].firstname, Toast.LENGTH_LONG).show()
    }

}