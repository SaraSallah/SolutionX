package com.example.solutionx.features.login.presentation

import com.example.solutionx.features.login.domain.model.User

data class LoginUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val userInfo: UserUiState = UserUiState(),
    val phoneNumber : String ="",
    val countryCode : String = "",
    val password : String = "",
)

data class UserUiState(
    val id: Int? = 0,
    val name: String? = "",
    val email: String? = "",
    val password: String? = "",
)

fun User.toUserUiState()=UserUiState(
    id = id ,
    name = name,
    email = email ,
    password = password ,
)
