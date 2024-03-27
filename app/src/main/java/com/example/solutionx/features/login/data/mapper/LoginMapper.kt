package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.dto.LoginResponseDto
import com.example.solutionx.features.login.domain.model.Login

internal object LoginMapper {

    fun mapToDomain(login: LoginResponseDto?) = Login(
        accessToken = login?.accessToken.orEmpty(),
        userInfo = UserMapper.mapToDomain(login?.user)

    )
}


