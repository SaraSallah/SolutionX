package com.example.solutionx_arch.data.models.Entity

data class LoginResponse(
    val accessToken : String? = null,
    val userInfo : User? = null,
)