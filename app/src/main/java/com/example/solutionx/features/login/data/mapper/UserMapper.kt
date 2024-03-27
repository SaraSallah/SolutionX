package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.data.models.dto.UserDto
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.model.User

internal object UserMapper {
    fun mapToDomain(user: UserDto?) = User(
        id = user?.id ?: 0,
        name = user?.firstname.orEmpty(),
        email = user?.email.orEmpty(),
    )
    fun mapToEntity(user : User?) = UserEntity(
        id = user?.id ?: 0,
        name = user?.name.orEmpty(),
        email = user?.email.orEmpty(),

    )
}

