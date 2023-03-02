package com.kerumitbsl.core.bean.response

import android.os.Parcelable
import com.kerumitbsl.core.bean.models.InfoObject
import com.kerumitbsl.core.bean.models.user.UserModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetUsersResponse(
    val results: Array<UserModel>,
    val info: InfoObject,
    val error: String?
) : Parcelable