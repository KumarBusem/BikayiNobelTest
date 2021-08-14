package com.busem.nobel.common

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : FragmentActivity() {

    private lateinit var binding: VB

    protected val viewModel: VM by lazy { setViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate.invoke(layoutInflater)
        binding.apply {
            setContentView(root)
            setupViews().invoke(binding)
        }
        viewModel.apply { setupObservers().invoke(viewModel) }
    }

    abstract fun setViewModel(): VM
    abstract fun setupViews(): VB.() -> Unit
    abstract fun setupObservers(): VM.() -> Unit



}

typealias Inflate<T> = (LayoutInflater) -> T