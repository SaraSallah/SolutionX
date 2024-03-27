package com.example.solutionx.features.login.domain.model

import com.example.solutionx.features.login.data.models.dto.UserInfoDto

data class Login(
    val accessToken: String ? = null,
    val userInfo: User? = null,
)