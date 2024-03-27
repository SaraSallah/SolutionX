package com.example.solutionx.common.data.repository.remote

import com.example.solutionx.features.login.data.models.dto.LoginResponseDto
import retrofit2.http.POST

 interface ApiServices {
    @POST("api/login")
    suspend fun loginWithPhone(
        countryCode: String,
        phoneNumber: String,
        password: String,
    ): LoginResponseDto
}