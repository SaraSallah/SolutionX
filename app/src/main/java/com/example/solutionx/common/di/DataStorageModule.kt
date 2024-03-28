package com.example.solutionx.common.di

import android.content.Context
import com.example.solutionx.common.data.repository.local.DataStorePreferences
import com.example.solutionx.common.data.repository.local.LocalDataStoreProviderImp
import com.example.solutionx.common.domain.remote.LocalDataStoreProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataStorageModule {
    @Provides
    fun provideDataStoreProvider(datStore: DataStorePreferences): LocalDataStoreProvider {
        return LocalDataStoreProviderImp(datStore)
    }

    @Provides
    fun provideLoginDataStore(context: Context): DataStorePreferences {
        return DataStorePreferences(context)
    }
}