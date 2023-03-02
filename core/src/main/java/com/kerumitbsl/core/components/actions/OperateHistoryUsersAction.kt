package com.kerumitbsl.core.components.actions

import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.core.components.room.NetronicDatabase
import com.kerumitbsl.core.components.room.UserEntity
import com.kerumitbsl.core.other.SingleLiveEvent

class OperateHistoryUsersAction(private val database: NetronicDatabase) {

    val historyUsersLiveData = SingleLiveEvent<TestTaskResponse<List<UserModel>>>()

    fun queryUsers() {
        historyUsersLiveData.postValue(TestTaskResponse.Success(mutableListOf<UserModel>().apply {
            database.getUserDao().getUsers().forEach { add(UserEntity.toUserModel(it)) }
        }))
    }

    fun putUser(userModel: UserModel) {
        database.getUserDao().putUser(userModel.toUserEntity())
    }
}