package com.example.solutionx.features.helper.di

import com.example.solutionx.features.helper.data.repository.HelperLocalDSImp
import com.example.solutionx.features.helper.domain.repository.HelperLocalDs
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal abstract class HelperDataModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(helperLocalDSImp: HelperLocalDSImp): HelperLocalDs

}
