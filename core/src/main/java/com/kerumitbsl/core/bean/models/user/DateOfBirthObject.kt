package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DateOfBirthObject(
    val date: String,
    val age: Int
) : Parcelable