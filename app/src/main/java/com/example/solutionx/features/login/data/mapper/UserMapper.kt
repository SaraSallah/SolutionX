package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.dto.UserInfoDto
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.User

internal object UserMapper {
    fun mapToDomain(user: UserInfoDto?) = User(
        id = user?.id ?: 0,
        name = user?.name.orEmpty(),
        email = user?.email.orEmpty(),
        password = user?.password.orEmpty(),
        age = user?.age ?: 0
    )
    fun mapToEntity(user : User?) = UserEntity(
        id = user?.id ?: 0,
        name = user?.name.orEmpty(),
        email = user?.email.orEmpty(),
        password = user?.password.orEmpty(),
        age = user?.age ?: 0

    )
}

