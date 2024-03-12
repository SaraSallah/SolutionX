package com.example.solutionx.data.models.Dto

import com.example.solutionx_arch.data.models.Dto.UserDto
import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("user")
    val user: UserDto,
    )
