package com.mainp.roomdemo01.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.mainp.roomdemo01.data.model.Task
import com.mainp.roomdemo01.data.model.User
import com.mainp.roomdemo01.data.model.UserWithTasks

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

//    @Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserWithTasks(userId: Int): LiveData<UserWithTasks>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

}
