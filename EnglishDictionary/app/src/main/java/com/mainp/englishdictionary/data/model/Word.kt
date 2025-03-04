package com.mainp.englishdictionary.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_tbl")
data class Word (
    @PrimaryKey
    val word: String,
    val av: String?,
    val dnpn: String?,
    val aa: String?,
    val mean: String?
)