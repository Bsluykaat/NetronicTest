package com.kerumitbsl.core.components

import com.kerumitbsl.core.components.actions.OperateHistoryUsersAction
import com.kerumitbsl.core.components.actions.GetUsersAction
import com.kerumitbsl.core.components.rest.HttpCommunicationComponent
import com.kerumitbsl.core.components.rest.TestTaskApi
import com.kerumitbsl.core.components.room.NetronicDatabase
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserLoadingComponent(networkCommunicationComponent: HttpCommunicationComponent): KoinComponent {
    private val service = networkCommunicationComponent.createService(TestTaskApi::class.java)
    private val localDataBase: NetronicDatabase by inject()

    val getUsersAction = GetUsersAction(service)
    val operateHistoryUsers = OperateHistoryUsersAction(localDataBase)
}