package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PictureObject(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Parcelable