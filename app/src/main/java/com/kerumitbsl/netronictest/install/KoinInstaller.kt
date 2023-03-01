package com.kerumitbsl.netronictest.install

import android.app.Application
import com.kerumitbsl.core.CoreApiBuilder
import com.kerumitbsl.netronictest.NetronicTestApp
import com.kerumitbsl.netronictest.ui.history.HistoryViewModel
import com.kerumitbsl.netronictest.ui.mainActivity.MainViewModel
import com.kerumitbsl.netronictest.ui.userInfo.UserInfoViewModel
import com.kerumitbsl.netronictest.ui.users.UsersViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinInstaller {

    private val appModule = module {
        single { androidApplication() as NetronicTestApp }
        single(createdAtStart = true) { CoreApiBuilder.build() }
    }

    private val viewModelModule = module {
        viewModel { UsersViewModel() }
        viewModel { UserInfoViewModel() }
        viewModel { HistoryViewModel() }
        viewModel { MainViewModel() }
    }

    fun install(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(appModule)
            modules(viewModelModule)
        }
    }
}