package com.example.solutionx.features.login.di

import com.example.solutionx.features.helper.data.repository.HelperRepositoryImp
import com.example.solutionx.features.helper.domain.repository.HelperRepository
import com.example.solutionx.features.login.data.repository.LocalDSImp
import com.example.solutionx.features.login.data.repository.LoginRepositoryImp
import com.example.solutionx.features.login.data.repository.RemoteDSImp
import com.example.solutionx.features.login.domain.repository.LocalDS
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.features.login.domain.repository.RemoteDS
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal abstract class LoginRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImp: LoginRepositoryImp
    ): LoginRepository
}
@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataBindingsModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDSImp: RemoteDSImp): RemoteDS
    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDSImp: LocalDSImp): LocalDS
}
