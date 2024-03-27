package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.dto.LoginDto
import com.example.solutionx.features.login.domain.model.Login

internal object LoginMapper {

    fun mapToDomain(login: LoginDto?) = Login(
        accessToken = login?.token.orEmpty(),
        userInfo = UserMapper.mapToDomain(login?.user)

    )
}


