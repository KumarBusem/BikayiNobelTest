package com.busem.nobel

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

class NobelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = WeakReference(applicationContext)
    }

    companion object {
        private var appContext: WeakReference<Context>? = null
        fun getAppContext() = appContext?.get() ?: throw RuntimeException("App context not found.")
    }
}