package com.example.solutionx.common.domain.remote

interface LocalDataStoreProvider {
    suspend fun <T> save(key: String, value: T)
    fun <T> get(key: String): T
}