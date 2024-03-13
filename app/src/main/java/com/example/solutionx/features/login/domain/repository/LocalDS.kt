package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.domain.model.User


interface LocalDS {
    fun saveAccessToken(token: String?): Boolean
    fun getUserInfo(token: String?) : User

}