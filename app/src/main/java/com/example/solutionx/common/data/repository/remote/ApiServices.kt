package com.example.solutionx.common.data.repository.remote

import com.example.solutionx.features.login.data.models.dto.LoginDto
import com.example.solutionx.features.login.domain.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

 interface ApiServices {
    @POST("login")
    suspend fun loginWithPhone(
        @Body loginRequest: LoginRequest): Response<LoginDto>
}