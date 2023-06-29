package com.linhpham.goodnight.data.alarm.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.linhpham.goodnight.base.BaseModel
import com.linhpham.goodnight.utils.CommonUtils

/**
 * Use
 * @see CommonUtils.generateId
 * to generate id
 */
@Entity(tableName = "alarm")
data class Alarm(
    @PrimaryKey
    override var id : String = CommonUtils.generateId(),
    override var userId: String,
    override var createdDate: Double,
    override var modifiedDate: Double,
    override var isSynced: Boolean,
    override var isDeleted: Boolean,
    override var isSyncedFlag: Boolean,

    var name : String,
    var description: String,
    var timeAlarm: Double,
    ) : BaseModel {

}