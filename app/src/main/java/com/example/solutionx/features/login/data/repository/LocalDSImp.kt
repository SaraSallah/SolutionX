package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LocalDS
import javax.inject.Inject

class LocalDSImp @Inject constructor() : LocalDS {
    override suspend fun saveAccessToken(token: String?) = true
    override suspend fun getUserInfo(token: String?)  =User()


}