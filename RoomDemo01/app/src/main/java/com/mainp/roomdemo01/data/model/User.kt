package com.mainp.roomdemo01.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val name: String,
    val age: Int
)