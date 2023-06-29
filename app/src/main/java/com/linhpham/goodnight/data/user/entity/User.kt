package com.linhpham.goodnight.data.user.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.linhpham.goodnight.base.BaseModel
import com.linhpham.goodnight.utils.CommonUtils
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @SerializedName("_id")
    override var id: String = "",
    override var isSynced: Boolean = false,
    override var isDeleted: Boolean = false,
    override var userId: String,
    override var modifiedDate: Double,
    override var isSyncedFlag: Boolean,
    override var createdDate: Double = CommonUtils.getTimeStamp(),

    @SerializedName("social_id")
    var socialId: String = "",
    @SerializedName("updated_date")
    var updatedDate: String = "",
    @SerializedName("first_name")
    var firstName: String = "",
    @SerializedName("last_name")
    var lastName: String = "",
    var email: String = "",
    @SerializedName("auth_type")
    var authType: String = "",
    var password: String = "",
    var avatar: String? = null,
    @SerializedName("social_token")
    var socialToken: String? = null,

    ) : Parcelable, BaseModel {
    fun getShortName(): String {
        return if (lastName.isNotBlank() && firstName.isNotBlank()) {
            "${firstName[0]}${lastName[0]}"
        } else if (lastName.isNotBlank()) {
            lastName[0].toString()
        } else {
            firstName.getOrNull(0)?.toString() ?: ""
        }
    }

    val fullName: String
        get() = if (firstName.isEmpty())
            lastName
        else if (lastName.isEmpty())
            firstName else "$firstName $lastName"
}

enum class AuthType(val value: String) {
    Google("google"),
    Facebook("facebook")
}
