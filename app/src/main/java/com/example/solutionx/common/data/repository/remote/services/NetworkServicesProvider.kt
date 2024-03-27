package com.example.solutionx.common.data.repository.remote.services

import com.example.solutionx.features.login.data.models.dto.LoginResponseDto
import com.example.solutionx.features.login.domain.model.LoginRequest
import retrofit2.Retrofit

internal interface NetworkServicesProvider {
    suspend fun <T, O> post(url: String, body: T): O
    suspend fun <O> Map<String, String>?.get(url: String): O
    suspend fun <O> delete(url: String, queryMap: Map<String, String>? = null): O
}