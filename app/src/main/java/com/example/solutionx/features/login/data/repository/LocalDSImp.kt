package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LocalDS

class LocalDSImp : LocalDS {
    override fun saveAccessToken(token: String?) = true
    override fun getUserInfo(token: String?) =User()


}