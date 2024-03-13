package com.example.solutionx.features.login.domain.model

data class Login (
    val accessToken : String ? = null,
    val userInfo : User? = null,
)