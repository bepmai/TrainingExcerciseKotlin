package com.mainp.englishdictionaryver2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite (
    @PrimaryKey
    val favId: String,
    val av: ByteArray?,
    val dnpn: ByteArray?,
    val aa: ByteArray?,
    val mean: String?
)