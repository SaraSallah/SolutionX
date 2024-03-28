package com.example.solutionx.features.login.data.models.entity

import com.google.gson.Gson

data class UserEntity(
    val id: Int,
    val name: String,
    val email: String,
)
fun UserEntity.toJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

fun String.toUserEntity(): UserEntity {
    val gson = Gson()
    return gson.fromJson(this, UserEntity::class.java)
}
