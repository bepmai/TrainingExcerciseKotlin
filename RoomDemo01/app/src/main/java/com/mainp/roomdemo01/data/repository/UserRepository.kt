package com.mainp.roomdemo01.data.repository

import androidx.lifecycle.LiveData

import com.mainp.roomdemo01.data.dao.UserDao
import com.mainp.roomdemo01.data.model.User

class UserRepository(private val userDao: UserDao) {

//    suspend fun insert(user: User) {
//        userDao.insert(user)
//    }
//
//    fun getAllUsers(): LiveData<List<User>> {
//        return userDao.getAllUsers()
//    }
}
