package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.LoginMapper
import com.example.solutionx.features.login.data.mapper.UserMapper
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import com.example.solutionx.features.login.domain.repository.remote.LoginRemoteDS

internal class LoginRepositoryImp(
    private val remoteDS: LoginRemoteDS,
    private val localDS: LoginLocalDS,
) : LoginRepository {
    override suspend fun loginWithEmail(email: String, password: String): Login =
        LoginMapper.mapToDomain(remoteDS.loginWithEmail(email, password))

    override suspend fun loginWithPhone(
        countryCode: String,
        phone: String,
        password: String,
    ): Login =
        LoginMapper.mapToDomain(remoteDS.loginWithPhone(countryCode, phone, password))

    override suspend fun loginWithSocial(socialAcc: String): Login =
        LoginMapper.mapToDomain(remoteDS.loginWithSocial(socialAcc))

    override suspend fun saveAccessToken(token: String) =
        localDS.saveAccessToken(token)

//    override suspend fun getUserInfo(token: String?): UserEntity =
//        UserMapper.mapToEntity(localDS.getUserInfo(token))
}