package com.zoose.snowboardstore.login

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _createAccountEvent = MutableLiveData<Boolean>()
    public val createAccountEvent: LiveData<Boolean> get() = _createAccountEvent

    private val _loginToAccountEvent = MutableLiveData<Boolean>()
    public val loginToAccountEvent: LiveData<Boolean> get() = _loginToAccountEvent

    private val _loggedIn = MutableLiveData<Boolean>()
    public val loggedIn: LiveData<Boolean> get() = _loggedIn

    private val _email = MutableLiveData<String>()
    public val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    public val password: LiveData<String> get() = _password

    private val _confirmPassword = MutableLiveData<String>()
    public val confirmPassword: LiveData<String> get() = _confirmPassword

    init {
        _createAccountEvent.value = false
        _loginToAccountEvent.value = true
        _loggedIn.value = false
    }

    fun onCreateAccount() {
        _createAccountEvent.value = true
    }

    fun onLoginToAccount() {
        _loginToAccountEvent.value = true
    }

    fun submitLogin() {
        _loggedIn.value = true
    }

    fun onCreateAccountEventFinished() {
        _createAccountEvent.value = false
    }

    fun onLoginToAccountEventFinished() {
        _loginToAccountEvent.value = false
    }
}