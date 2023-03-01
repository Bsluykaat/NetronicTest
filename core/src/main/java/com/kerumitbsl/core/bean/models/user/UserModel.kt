package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val gender: String,
    val name: NameObject,
    val email: String,
    val dob: DateOfBirthObject,
    val picture: PictureObject,
    val id: IdObject,
    val nat: String
) : Parcelable