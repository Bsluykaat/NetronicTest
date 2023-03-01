package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NameObject(
    val title: String,
    val first: String,
    val last: String
) : Parcelable