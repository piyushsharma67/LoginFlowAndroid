package com.example.loginflow.appDB.user.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id:Int,
    val name:String,
    val email:String,
    val phone:String,
    val token:String
){
    companion object{
        fun loading(): User {
            // Return a user object representing a loading state
            return User(
                id = -1, // or any value that represents a loading state
                name = "Loading...",
                email = "",
                phone = "",
                token = ""
            )
        }
    }
}
