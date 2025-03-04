package com.mainp.englishdictionary.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_tbl")
data class Favorite (
    @PrimaryKey
    val word: String,
    val av: String?,
    val dnpn: String?,
    val aa: String?,
    val mean: String?
)