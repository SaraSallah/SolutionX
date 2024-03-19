package com.example.solutionx.features.login.presenter

import com.example.solutionx.features.login.domain.model.User

data class LoginUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val userInfo: UserUiState = UserUiState(),
    val email : String ="",
    val password : String = "",
    val socialAcc : String ="",
    val phone : String ="",
)

data class UserUiState(
    val id: Int? = 0,
    val name: String? = "",
    val email: String? = "",
    val password: String? = "",
    val age: Int? = 0,
)

fun User.toUserUiState()=UserUiState(
    id = id ,
    name = name,
    email = email ,
    password = password ,
    age = age
)
