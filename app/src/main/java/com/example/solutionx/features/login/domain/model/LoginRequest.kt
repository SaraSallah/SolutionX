package com.example.solutionx.features.login.domain.model

data class LoginRequest(
    val countryCode : String,
    val phoneNumber : String ,
    val password : String ,
)
