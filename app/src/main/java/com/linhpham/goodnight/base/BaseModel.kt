package com.linhpham.goodnight.base

/**
 * Created by Habbot Phan on 10/14/2022.
 **/
interface BaseModel{
    var id: String
    var userId: String
    var createdDate: Double
    var modifiedDate: Double
    var isSynced: Boolean
    var isDeleted: Boolean
    var isSyncedFlag: Boolean
}
