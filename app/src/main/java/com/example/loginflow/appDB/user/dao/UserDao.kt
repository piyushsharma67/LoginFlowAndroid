package com.example.loginflow.appDB.user.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.loginflow.appDB.user.dbModel.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): User
}