package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.Dto.LoginResponseDto
import kotlinx.coroutines.flow.Flow


interface RemoteDS {
    suspend  fun loginWithEmail(email : String , password : String): LoginResponseDto
    suspend fun loginWithPhone(phone : String): LoginResponseDto
    suspend  fun loginWithSocial(socialAcc : String): LoginResponseDto

}