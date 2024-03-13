package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.Dto.LoginResponseDto
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx_arch.data.models.Entity.LoginResponse

fun LoginResponseDto.toLogin() = Login(
    accessToken = accessToken,
    userInfo = user?.toUserEntity()
)
fun Login.toLoginEntity() = LoginResponse(
    accessToken = accessToken,
    userInfo = userInfo?.toUserEntity()
)
