package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.toLogin
import com.example.solutionx.features.login.data.mapper.toUserEntity
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.repository.LocalDS
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.features.login.domain.repository.RemoteDS
import com.example.solutionx_arch.data.models.Entity.User
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val remoteDS: RemoteDS,
    private val localDS : LocalDS,
) : LoginRepository {
    override suspend fun loginWithEmail(email: String, password: String): Login =
        remoteDS.loginWithEmail(email, password).toLogin()

    override suspend fun loginWithPhone(phone: String): Login =
        remoteDS.loginWithPhone(phone).toLogin()

    override suspend fun loginWithSocial(socialAcc: String): Login =
        remoteDS.loginWithSocial(socialAcc).toLogin()

    override suspend fun saveAccessToken(token: String?): Boolean =
        localDS.saveAccessToken(token)

    override suspend fun saveUserInfo(token: String?): User =
        localDS.getUserInfo(token).toUserEntity()
}