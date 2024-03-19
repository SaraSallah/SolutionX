package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.models.Dto.LoginResponseDto
import com.example.solutionx.features.login.domain.repository.RemoteDS
import javax.inject.Inject

class RemoteDSImp @Inject constructor() : RemoteDS {
    override suspend fun loginWithEmail(email: String, password: String): LoginResponseDto = LoginResponseDto()

    override suspend fun loginWithPhone(phone: String): LoginResponseDto = LoginResponseDto()

    override suspend fun loginWithSocial(socialAcc: String): LoginResponseDto = LoginResponseDto()
}