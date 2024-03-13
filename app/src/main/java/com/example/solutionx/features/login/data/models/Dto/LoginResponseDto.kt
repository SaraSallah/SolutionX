package com.example.solutionx.features.login.data.models.Dto

import com.example.solutionx_arch.data.models.Dto.UserInfoDto
import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("accessToken")
    val accessToken: String? = null,
    @SerializedName("user")
    val user: UserInfoDto? = null,
    )
