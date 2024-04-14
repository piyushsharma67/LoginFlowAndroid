package com.example.loginflow

import com.example.loginflow.appDB.AppDB
import com.example.loginflow.appDB.user.dbModel.User
import com.example.loginflow.utils.GenericResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class RootRepository @Inject constructor(private val dbService:AppDB) {

    fun getUser(): Flow<GenericResult<out User>> {
        return  flow {
            emit(GenericResult.Loading)

            delay(2000)

            emit(GenericResult.Success(User(id = 1, name = "piyush", phone = "324234", email = "dasdasd", token = "dsadasdsadsad")))
        }.catch {
            emit(GenericResult.Error(it.message.toString() ?: "Unknown error"))
        }
    }
}