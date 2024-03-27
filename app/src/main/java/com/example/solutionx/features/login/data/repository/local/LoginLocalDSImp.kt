package com.example.solutionx.features.login.data.repository.local

import com.example.solutionx.common.data.repository.local.LocalDataStoreProvider
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import javax.inject.Inject

internal class LoginLocalDSImp (
    private val loginDataStorePreferences: LoginDataStorePreferences
) : LoginLocalDS {
    override suspend fun saveAccessToken(token: String) =
        loginDataStorePreferences.saveAccessToken(token)

    override suspend fun saveUserInfo(user: UserEntity) {
        loginDataStorePreferences.saveUserInfo(user)
    }

    override suspend fun getUSerInfo(): UserEntity =
        loginDataStorePreferences.getUSerInfo()
}