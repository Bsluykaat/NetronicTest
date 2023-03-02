package com.kerumitbsl.core.components.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): List<UserEntity>

    @Insert
    fun putUser(userEntity: UserEntity)
}