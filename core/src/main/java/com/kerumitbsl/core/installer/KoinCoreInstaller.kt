package com.kerumitbsl.core.installer

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.kerumitbsl.core.DatabaseBuilder
import com.kerumitbsl.core.components.UserLoadingComponent
import com.kerumitbsl.core.components.rest.HttpCommunicationComponent
import com.kerumitbsl.core.components.room.NetronicDatabase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
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

    private lateinit var databaseModule: Module

    fun install(context: Context) {
        databaseModule = module { single { DatabaseBuilder.buildDatabase(context) } }
        koinApplication {
            loadKoinModules(listOf(componentsModule, supportModule, databaseModule))
        }
    }
}