package com.example.solutionx.common.data.repository.remote.services

internal interface NetworkServicesProvider {
    suspend fun <T, O> post(url: String, body: T): O
    suspend fun <O> Map<String, String>?.get(url: String): O
    suspend fun <O> delete(url: String, queryMap: Map<String, String>? = null): O
}