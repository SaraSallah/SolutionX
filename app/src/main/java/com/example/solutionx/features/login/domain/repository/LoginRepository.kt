package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.domain.model.Login

interface LoginRepository {
    fun loginWithEmail(email: String, password: String): Login
    fun loginWithPhone(phone: String): Login
    fun loginWithSocial(socialAcc: String): Login
    fun saveAccessToken(token: String?): Boolean
    fun saveUserInfo(token: String?) : com.example.solutionx_arch.data.models.Entity.User


}