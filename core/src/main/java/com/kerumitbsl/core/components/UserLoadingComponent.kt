package com.kerumitbsl.core.components

import com.kerumitbsl.core.components.actions.GetHistoryUsersAction
import com.kerumitbsl.core.components.actions.GetUsersAction
import com.kerumitbsl.core.components.rest.HttpCommunicationComponent
import com.kerumitbsl.core.components.rest.TestTaskApi

class UserLoadingComponent(networkCommunicationComponent: HttpCommunicationComponent) {
    private val service = networkCommunicationComponent.createService(TestTaskApi::class.java)

    val getUsersAction = GetUsersAction(service)
    val getHistoryUsers = GetHistoryUsersAction()
}