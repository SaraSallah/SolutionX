package com.example.solutionx.features.login.domain.repository.local

import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.User


internal interface LoginLocalDS {
    suspend fun saveAccessToken(token: String)
    suspend fun saveUserInfo(user: UserEntity)
    suspend fun getUSerInfo():UserEntity

}