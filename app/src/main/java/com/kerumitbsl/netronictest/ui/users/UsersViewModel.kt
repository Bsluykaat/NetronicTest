package com.kerumitbsl.netronictest.ui.users

import androidx.lifecycle.viewModelScope
import com.kerumitbsl.core.bean.response.GetUsersResponse
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.extensions.RESULTS_PER_PAGE
import com.kerumitbsl.core.other.SingleLiveEvent
import com.kerumitbsl.netronictest.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel : BaseViewModel() {

    val usersLiveData: SingleLiveEvent<TestTaskResponse<GetUsersResponse>> get() = coreApi.getLoadUsersLiveData()

    private var pageIndex = 1

    fun refreshPagination() { pageIndex = 1 }

    fun loadUsersRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            coreApi.loadUsersRequest(RESULTS_PER_PAGE, pageIndex)
            pageIndex++
        }
    }
}