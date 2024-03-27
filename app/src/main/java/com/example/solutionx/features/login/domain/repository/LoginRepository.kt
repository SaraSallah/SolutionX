package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.model.LoginRequest
import com.example.solutionx.features.login.domain.model.User

interface LoginRepository {
    suspend fun loginWithEmail(email: String, password: String): Login
    suspend fun loginWithPhone(loginRequest: LoginRequest): Login
    suspend fun loginWithSocial(socialAcc: String): Login
    suspend fun saveAccessToken(token: String)
    suspend fun saveUserInfo(user: User)
//    suspend fun getUserInfo(token: String?): UserEntity


}