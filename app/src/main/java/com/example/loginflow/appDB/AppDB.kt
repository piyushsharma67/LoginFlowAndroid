package com.example.loginflow.appDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loginflow.appDB.user.dao.UserDao
import com.example.loginflow.appDB.user.dbModel.User

@Database(entities = [User::class], version = 1)
abstract class AppDB:RoomDatabase() {
    abstract fun userDao(): UserDao
}