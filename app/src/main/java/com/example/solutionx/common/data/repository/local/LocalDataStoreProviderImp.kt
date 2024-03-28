package com.example.solutionx.common.data.repository.local

import com.example.solutionx.common.domain.remote.LocalDataStoreProvider
import javax.inject.Inject

class LocalDataStoreProviderImp (
    private val dataStorePreferences: DataStorePreferences
) : LocalDataStoreProvider {
    override suspend fun <T> save(key: String, value: T) {
        dataStorePreferences.save(key, value)
    }
    override fun <T> get(key: String): T {
        return dataStorePreferences.get(key)
    }
}