package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import com.kerumitbsl.core.components.room.UserEntity
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
) : Parcelable {

    fun toUserEntity(): UserEntity = UserEntity(
        uid = 0,
        first = this.name.first,
        last = this.name.last,
        title = this.name.title,
        date = this.dob.date,
        age = this.dob.age,
        gender = this.gender,
        value = this.id.value,
        name = this.id.name,
        email = this.email,
        thumbnail = this.picture.thumbnail,
        medium = this.picture.medium,
        large = this.picture.large,
        nat = this.nat
    )
}