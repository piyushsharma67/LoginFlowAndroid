package com.example.loginflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginflow.appDB.user.dbModel.User
import com.example.loginflow.utils.GenericResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(private val rootRepository: RootRepository):ViewModel() {

    private var _userData = MutableStateFlow<GenericResult<out User>>(GenericResult.Loading)
    val userData: StateFlow<GenericResult<out User>> = _userData

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            rootRepository.getUser()
                .onStart { _userData.value =GenericResult.Loading }
                .collect{
                        _userData.value = it
                }
        }
    }
}