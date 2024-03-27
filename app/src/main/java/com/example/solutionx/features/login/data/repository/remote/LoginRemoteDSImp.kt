package com.example.solutionx.features.login.data.repository.remote

import com.example.solutionx.common.data.repository.remote.ApiServices
import com.example.solutionx.features.login.data.models.dto.LoginResponseDto
import com.example.solutionx.features.login.domain.repository.remote.LoginRemoteDS
import javax.inject.Inject

internal class LoginRemoteDSImp @Inject constructor(
    private val loginServices: ApiServices,
) : LoginRemoteDS {
    override suspend fun loginWithEmail(email: String, password: String):
            LoginResponseDto = LoginResponseDto()

    override suspend fun loginWithPhone(
        countryCode: String,
        phone: String,
        password: String,
    ): LoginResponseDto =
        loginServices.loginWithPhone(countryCode, phone, password)

    override suspend fun loginWithSocial(socialAcc: String): LoginResponseDto = LoginResponseDto()
}