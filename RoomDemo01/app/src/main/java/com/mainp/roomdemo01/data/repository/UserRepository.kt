package com.mainp.roomdemo01.data.repository

import androidx.lifecycle.LiveData

import com.mainp.roomdemo01.data.dao.UserDao
import com.mainp.roomdemo01.data.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

}
