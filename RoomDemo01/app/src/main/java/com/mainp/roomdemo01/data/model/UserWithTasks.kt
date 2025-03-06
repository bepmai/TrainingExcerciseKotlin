package com.mainp.roomdemo01.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithTasks(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userid"
    )
    val tasks: List<Task>
)
