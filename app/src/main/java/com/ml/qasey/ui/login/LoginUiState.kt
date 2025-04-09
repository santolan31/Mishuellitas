package com.ml.qasey.ui.login

data class LoginUiState(

    val userName: String = "",
    val passWord: String = "",
    val usernameError : String? = "",
    val passworError: String? = "",
    val isLoginSuccesful:Boolean = false,
    val showDialog : Boolean = false,
    val isloading: Boolean = false

)
