package com.example.solutionx.common.data.repository.local

interface LocalDataStoreProvider {
    suspend fun <T> save(key: String, value: T)
    fun <T> get(key: String): T
}