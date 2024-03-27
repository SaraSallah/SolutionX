package com.example.solutionx.features.login.data.models.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("accessToken")
    val accessToken: String? = null,
    @SerializedName("user")
    val user: UserInfoDto? = null,
    )
