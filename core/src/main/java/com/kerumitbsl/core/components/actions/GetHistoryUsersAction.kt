package com.kerumitbsl.core.components.actions

import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.other.SingleLiveEvent

class GetHistoryUsersAction {

    val historyUsersLiveData = SingleLiveEvent<TestTaskResponse<List<UserModel>>>()

    fun queryUsers() {

    }
}