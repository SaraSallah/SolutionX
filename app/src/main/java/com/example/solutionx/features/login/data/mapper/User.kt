package com.example.solutionx.features.login.data.mapper

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx_arch.data.models.Dto.UserInfoDto


fun UserInfoDto.toUser() = User(
    id = id,
    name = name,
    email = email,
    password = password,
    age = age,
)
fun User.toUserEntity() = com.example.solutionx_arch.data.models.Entity.User(
    id = id,
    name = name,
    email = email,
    password = password,
    age = age,
)