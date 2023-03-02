package com.kerumitbsl.core.bean.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    val infoObject: InfoObject?,
    val error: String
) : Parcelable