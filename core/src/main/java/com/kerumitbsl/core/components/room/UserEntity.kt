package com.kerumitbsl.core.components.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kerumitbsl.core.bean.models.user.*

@Entity(tableName = "user")
class UserEntity(

    @PrimaryKey(autoGenerate = true) val uid: Int,

    @ColumnInfo("title") val title: String,
    @ColumnInfo("first_name") val first: String,
    @ColumnInfo("last_name") val last: String,

    @ColumnInfo("date_of_birth") val date: String,
    @ColumnInfo("age") val age: Int,

    @ColumnInfo("gender") val gender: String,

    @ColumnInfo("id_value") val value: String?,
    @ColumnInfo("id_type") val name: String,

    @ColumnInfo("email") val email: String,

    @ColumnInfo("thumbnail_src") val thumbnail: String,
    @ColumnInfo("medium_src") val medium: String,
    @ColumnInfo("large_src") val large: String,

    @ColumnInfo("nationality") val nat: String
) {
    companion object {
        fun toUserModel(userEntity: UserEntity): UserModel = UserModel(
            gender = userEntity.gender,
            name = NameObject(
                title = userEntity.title,
                first = userEntity.first,
                last = userEntity.last
            ),
            email = userEntity.email,
            dob = DateOfBirthObject(
                date = userEntity.date,
                age = userEntity.age),
            picture = PictureObject(
                large = userEntity.large,
                medium = userEntity.medium,
                thumbnail = userEntity.thumbnail
            ),
            id = IdObject(
                name = userEntity.name,
                value = userEntity.value),
            nat = userEntity.nat
        )
    }
}