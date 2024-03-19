package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.domain.model.User


interface LocalDS {
    suspend fun saveAccessToken(token: String?): Boolean
    suspend fun getUserInfo(token: String?) :  User

}