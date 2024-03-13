package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.Dto.LoginResponseDto

interface RemoteDS {
    fun loginWithEmail(email : String , password : String): LoginResponseDto
    fun loginWithPhone(phone : String): LoginResponseDto
    fun loginWithSocial(socialAcc : String): LoginResponseDto

}