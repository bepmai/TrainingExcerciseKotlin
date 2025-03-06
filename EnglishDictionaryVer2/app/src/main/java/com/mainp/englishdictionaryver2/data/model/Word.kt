package com.mainp.englishdictionaryver2.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.util.Base64
import java.io.Serializable


@Entity(tableName = "word_tbl")
data class Word (
    @PrimaryKey
    val word: String,
    val av: ByteArray?,
    val dnpn: ByteArray?,
    val aa: ByteArray?,
    val mean: String?,
    var isFavorite: Boolean = false
): Serializable


