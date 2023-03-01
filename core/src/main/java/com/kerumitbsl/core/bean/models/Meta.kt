package com.kerumitbsl.core.bean.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
) : Parcelable