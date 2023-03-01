package com.kerumitbsl.core

import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.GetUsersResponse
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.components.UserLoadingComponent
import com.kerumitbsl.core.other.SingleLiveEvent
import org.koin.core.KoinComponent
import org.koin.core.inject

class CoreApi : KoinComponent {

    private val userLoadingComponent: UserLoadingComponent by inject()

    fun loadUsersRequest(results: Int, page: Int) = userLoadingComponent.getUsersAction.loadUsersRequest(results, page)
    fun getLoadUsersLiveData(): SingleLiveEvent<TestTaskResponse<GetUsersResponse>> = userLoadingComponent.getUsersAction.usersLiveData

    fun getHistoryUsers() = userLoadingComponent.getHistoryUsers.queryUsers()
    fun getHistoryUsersLiveData(): SingleLiveEvent<TestTaskResponse<List<UserModel>>> = userLoadingComponent.getHistoryUsers.historyUsersLiveData
}