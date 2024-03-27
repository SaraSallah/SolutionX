package com.example.solutionx.features.login.data.repository.local

import com.example.solutionx.common.data.repository.local.LocalDataStoreProvider
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import javax.inject.Inject

internal class LoginLocalDSImp @Inject constructor(
    private val loginDataStorePreferences: LoginDataStorePreferences
//    private val localDataStoreProvider : LocalDataStoreProvider,
) : LoginLocalDS {
    override suspend fun saveAccessToken(token: String) =
        loginDataStorePreferences.saveAccessToken(token)
}