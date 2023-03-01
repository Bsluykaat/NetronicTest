package com.kerumitbsl.netronictest.base

import androidx.lifecycle.AndroidViewModel
import com.kerumitbsl.core.CoreApi
import com.kerumitbsl.netronictest.NetronicTestApp
import org.koin.core.Koin
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel: AndroidViewModel(NetronicTestApp.application), KoinComponent {

    val coreApi: CoreApi by inject()
}