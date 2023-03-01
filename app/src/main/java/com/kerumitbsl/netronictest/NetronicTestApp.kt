package com.kerumitbsl.netronictest

import android.app.Application
import com.kerumitbsl.netronictest.install.KoinInstaller

class NetronicTestApp: Application() {

    override fun onCreate() {
        KoinInstaller().install(this)
        super.onCreate()
    }

    companion object {
        lateinit var application: NetronicTestApp
    }
}