package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.Login

interface LoginRepository {
    suspend fun loginWithEmail(email: String, password: String): Login
    suspend fun loginWithPhone(countryCode: String, phone: String, password: String): Login
    suspend fun loginWithSocial(socialAcc: String): Login
    suspend fun saveAccessToken(token: String)
//    suspend fun getUserInfo(token: String?): UserEntity


}