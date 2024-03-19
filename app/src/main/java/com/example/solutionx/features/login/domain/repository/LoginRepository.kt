package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.domain.model.Login

interface LoginRepository {
    suspend fun loginWithEmail(email: String, password: String): Login
    suspend fun loginWithPhone(phone: String): Login
    suspend fun loginWithSocial(socialAcc: String): Login
    suspend fun saveAccessToken(token: String?): Boolean
    suspend  fun saveUserInfo(token: String?) : com.example.solutionx_arch.data.models.Entity.User


}