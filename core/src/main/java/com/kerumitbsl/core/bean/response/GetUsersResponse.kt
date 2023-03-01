package com.kerumitbsl.core.bean.response

import android.os.Parcelable
import com.kerumitbsl.core.bean.models.Meta
import com.kerumitbsl.core.bean.models.user.UserModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetUsersResponse(
    val results: Array<UserModel>,
    val info: Meta,
    val error: String?
) : Parcelable