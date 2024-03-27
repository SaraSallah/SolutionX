package com.example.solutionx.features.login.domain.repository.remote

import com.example.solutionx.features.login.data.models.dto.LoginDto
import com.example.solutionx.features.login.domain.model.LoginRequest
import retrofit2.Response


internal interface LoginRemoteDS {
    suspend  fun loginWithEmail(email : String , password : String): LoginDto
    suspend fun loginWithPhone(
      loginRequest: LoginRequest
    ): LoginDto?
    suspend  fun loginWithSocial(socialAcc : String): LoginDto

}