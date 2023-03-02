package com.kerumitbsl.core

import android.content.Context
import com.kerumitbsl.core.installer.KoinCoreInstaller


object CoreApiBuilder {

    fun build(context: Context): CoreApi {
        KoinCoreInstaller().install(context)
        return CoreApi()
    }
}