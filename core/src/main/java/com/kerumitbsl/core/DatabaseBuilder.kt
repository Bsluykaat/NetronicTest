package com.kerumitbsl.core

import android.content.Context
import androidx.room.Room
import com.kerumitbsl.core.components.room.NetronicDatabase

object DatabaseBuilder {

    fun buildDatabase(context: Context): NetronicDatabase =
        Room.databaseBuilder(context, NetronicDatabase::class.java, "local_database").build()
}