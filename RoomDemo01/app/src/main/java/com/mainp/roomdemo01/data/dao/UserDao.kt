package com.mainp.roomdemo01.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mainp.roomdemo01.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

    @Insert
    fun insert(user: User)

}
