package com.zoose.snowboardstore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _createAccountEvent = MutableLiveData<Boolean>()
    public val createAccountEvent: LiveData<Boolean> get() = _createAccountEvent

    private val _loginToAccountEvent = MutableLiveData<Boolean>()
    public val loginToAccountEvent: LiveData<Boolean> get() = _loginToAccountEvent

    init {
        _createAccountEvent.value = false
        _loginToAccountEvent.value = true
    }

    fun onCreateAccount() {
        _createAccountEvent.value = true
    }

    fun onLoginToAccount() {
        _loginToAccountEvent.value = true
    }
}