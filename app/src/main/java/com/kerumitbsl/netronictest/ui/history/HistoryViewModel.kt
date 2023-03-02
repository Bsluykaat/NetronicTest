package com.kerumitbsl.netronictest.ui.history

import androidx.lifecycle.viewModelScope
import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.other.SingleLiveEvent
import com.kerumitbsl.netronictest.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel : BaseViewModel() {

    val historyLiveData: SingleLiveEvent<TestTaskResponse<List<UserModel>>> get() = coreApi.getHistoryUsersLiveData()

    fun queryHistoryUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            coreApi.getHistoryUsers()
        }
    }
}