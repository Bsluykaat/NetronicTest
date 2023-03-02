package com.kerumitbsl.core.components.actions

import com.kerumitbsl.core.bean.models.Meta
import com.kerumitbsl.core.bean.response.GetUsersResponse
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.components.rest.TestTaskApi
import com.kerumitbsl.core.other.SingleLiveEvent

class GetUsersAction(private val service: TestTaskApi) {

    val usersLiveData = SingleLiveEvent<TestTaskResponse<GetUsersResponse>>()

    fun loadUsersRequest(results: Int, page: Int) {
        val rs = service.getUsers(results = results, page = page)

        if (rs.error.isNullOrBlank()) {
            usersLiveData.postValue(TestTaskResponse.Success(rs))
        } else {
            usersLiveData.postValue(TestTaskResponse.Error(Meta(rs.info, rs.error)))
        }
    }
}