package com.kerumitbsl.core.components.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class NetronicDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}