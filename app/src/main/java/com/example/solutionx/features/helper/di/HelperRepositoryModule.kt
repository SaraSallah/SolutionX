package com.example.solutionx.features.helper.di

import com.example.solutionx.features.helper.data.repository.HelperLocalDSImp
import com.example.solutionx.features.helper.data.repository.HelperRepositoryImp
import com.example.solutionx.features.helper.domain.repository.HelperLocalDs
import com.example.solutionx.features.helper.domain.repository.HelperRepository
import com.example.solutionx.features.login.data.repository.LocalDSImp
import com.example.solutionx.features.login.data.repository.RemoteDSImp
import com.example.solutionx.features.login.domain.repository.LocalDS
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
internal abstract class  HelperRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindHelperRepository(
        helperRepositoryImp: HelperRepositoryImp
    ): HelperRepository
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkBindingsModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(helperLocalDSImp: HelperLocalDSImp): HelperLocalDs

}

