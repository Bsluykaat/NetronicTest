package com.kerumitbsl.core.bean.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class InfoObject(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
): Parcelable