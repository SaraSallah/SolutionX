package com.example.solutionx.features.login.data.models.entity

import com.example.solutionx.features.login.data.models.entity.UserEntity

internal data class LoginResponseEntity(
    val accessToken : String? = null,
    val userInfo : UserEntity? = null,
)
