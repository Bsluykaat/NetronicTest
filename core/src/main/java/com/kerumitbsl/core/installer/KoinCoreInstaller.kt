package com.kerumitbsl.core.installer

import com.google.gson.Gson
import com.kerumitbsl.core.components.UserLoadingComponent
import com.kerumitbsl.core.components.rest.HttpCommunicationComponent
import org.koin.core.context.loadKoinModules
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class KoinCoreInstaller {

    private val componentsModule = module {
        single { HttpCommunicationComponent(get()) }
        single { UserLoadingComponent(get()) }
    }

    private val supportModule = module {
        single { Gson() }
    }

    fun install() {
        koinApplication {
            loadKoinModules(listOf(componentsModule, supportModule))
        }
    }
}