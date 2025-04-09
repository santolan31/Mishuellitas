package com.ml.qasey.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewmodel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow(LoginUiState())

    val uiState: StateFlow<LoginUiState> = _uiState



    fun updateUsernameValue(value: String) {
        _uiState.value = _uiState.value.copy(userName = value)
    }

    fun updatePassword(value: String) {
        _uiState.value = _uiState.value.copy(passWord = value)
    }

    fun login() {
        val currentState = _uiState.value
        val usernameError =
            if (currentState.userName.isEmpty()) "Ingresa un correo electronico" else null
        val paswordError = if (currentState.passWord.isEmpty()) "Ingresa tu contraseña" else null

        val hasError = usernameError != null || paswordError != null

        _uiState.value = currentState.copy(
            usernameError = usernameError,
            passworError = paswordError,
            isLoginSuccesful = usernameError == null && paswordError == null,
            showDialog = hasError

        )
    }

    fun onUpdateShowDialog(value: Boolean) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(showDialog = value)
        }
    }

    fun Loginfirebase( onNavigate: ()-> Unit ) {
        val currentState = _uiState.value



    }

}

