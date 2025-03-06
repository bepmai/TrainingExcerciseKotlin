package com.mainp.roomdemo01.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "tasks",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"], // khóa ngoại tham chiếu
        onDelete = ForeignKey.CASCADE
    )]
)
data class Task(
    @PrimaryKey(autoGenerate = true) val taskId: Int = 0,
    val userId: Int,
    val taskName: String,
    val isCompleted: Boolean
)
