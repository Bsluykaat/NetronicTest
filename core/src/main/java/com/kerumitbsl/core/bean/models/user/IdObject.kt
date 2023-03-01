package com.kerumitbsl.core.bean.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class IdObject(
    val name: String,
    val value: String,
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        val casted = other as IdObject
        return this.name == casted.name && this.value == casted.value
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
}