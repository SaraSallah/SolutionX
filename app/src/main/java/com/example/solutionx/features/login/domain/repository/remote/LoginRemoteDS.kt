package com.example.solutionx.features.login.domain.repository.remote

import com.example.solutionx.features.login.data.models.dto.LoginResponseDto


internal interface LoginRemoteDS {
    suspend  fun loginWithEmail(email : String , password : String): LoginResponseDto
    suspend fun loginWithPhone(
        countryCode: String,
        phone: String,
        password: String,
    ): LoginResponseDto
    suspend  fun loginWithSocial(socialAcc : String): LoginResponseDto

}