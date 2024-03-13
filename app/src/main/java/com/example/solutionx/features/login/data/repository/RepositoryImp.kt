package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.toLogin
import com.example.solutionx.features.login.data.mapper.toUserEntity
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.repository.Repository
import com.example.solutionx_arch.data.models.Entity.User
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val remoteDS: RemoteDSImp,
    private val localDS :  LocalDSImp ,
) : Repository {
    override fun loginWithEmail(email: String, password: String): Login =
        remoteDS.loginWithEmail(email, password).toLogin()

    override fun loginWithPhone(phone: String): Login =
        remoteDS.loginWithPhone(phone).toLogin()

    override fun loginWithSocial(socialAcc: String): Login =
        remoteDS.loginWithSocial(socialAcc).toLogin()

    override fun saveAccessToken(token: String?): Boolean =
        localDS.saveAccessToken(token)

    override fun saveUserInfo(token: String?): User =
        localDS.getUserInfo(token).toUserEntity()
}