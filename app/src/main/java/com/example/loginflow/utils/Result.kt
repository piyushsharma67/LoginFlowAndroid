package com.example.loginflow.utils

sealed class GenericResult<T>{
    data class Success<T>(val data: T) : GenericResult<T>()
    object Loading : GenericResult<Nothing>()
    data class Error(val message: String) : GenericResult<Nothing>()
}
