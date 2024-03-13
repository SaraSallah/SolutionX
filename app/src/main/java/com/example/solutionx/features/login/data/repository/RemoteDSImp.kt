package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.models.Dto.LoginResponseDto
import com.example.solutionx.features.login.domain.repository.RemoteDS

class RemoteDSImp : RemoteDS {
    override fun loginWithEmail(email: String, password: String): LoginResponseDto = LoginResponseDto()

    override fun loginWithPhone(phone: String): LoginResponseDto = LoginResponseDto()

    override fun loginWithSocial(socialAcc: String): LoginResponseDto = LoginResponseDto()
}