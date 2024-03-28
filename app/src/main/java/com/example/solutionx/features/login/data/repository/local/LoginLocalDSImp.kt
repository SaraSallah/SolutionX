package com.example.solutionx.features.login.data.repository.local

import android.util.Log
import com.example.solutionx.common.data.repository.local.DataStorePreferences
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.data.models.entity.toUserEntity
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import com.example.solutionx.utils.Constant
import javax.inject.Inject

internal class LoginLocalDSImp @Inject constructor(
//    private val loginDataStorePreferences: LoginDataStorePreferences
    private val loginDataStorePreferences: DataStorePreferences
) : LoginLocalDS {
    override suspend fun saveAccessToken(token: String) =
        loginDataStorePreferences.save(Constant.ACCESS_TOKEN_KEY, token)

    override suspend fun saveUserInfo(user: UserEntity) {
        loginDataStorePreferences.save(Constant.USER_INFO_KEY, user)

    }

    override suspend fun getUSerInfo(): UserEntity {
        val userInfoString = loginDataStorePreferences.get(Constant.USER_INFO_KEY) as String
        val userEntity: UserEntity = userInfoString.toUserEntity()
            return userEntity


    }
}