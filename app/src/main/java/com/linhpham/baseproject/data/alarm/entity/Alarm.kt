package com.linhpham.baseproject.data.alarm.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.linhpham.baseproject.base.BaseModel
import com.linhpham.baseproject.utils.CommonUtils

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

    var name : String,
    var description: String,
    var timeAlarm: Double,
    ) : BaseModel {

}