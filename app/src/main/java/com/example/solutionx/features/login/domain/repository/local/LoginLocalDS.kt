package com.example.solutionx.features.login.domain.repository.local

import com.example.solutionx.features.login.domain.model.User


internal interface LoginLocalDS {
    suspend fun saveAccessToken(token: String)
//    suspend fun getUserInfo(token: String?) :  User

}