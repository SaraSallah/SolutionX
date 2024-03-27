package com.example.solutionx.features.login.data.models.dto

import com.google.gson.annotations.SerializedName

 data class UserInfoDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("age")
    val age: Int? = null,
)