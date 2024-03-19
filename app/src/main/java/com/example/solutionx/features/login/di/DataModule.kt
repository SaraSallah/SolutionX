package com.example.solutionx.features.login.di

import com.example.solutionx.features.login.data.repository.LocalDSImp
import com.example.solutionx.features.login.data.repository.RemoteDSImp
import com.example.solutionx.features.login.domain.repository.LocalDS
import com.example.solutionx.features.login.domain.repository.RemoteDS
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LoginDataModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDSImp: RemoteDSImp): RemoteDS
    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDSImp: LocalDSImp): LocalDS
}
