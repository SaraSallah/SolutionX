package com.example.solutionx.features.selection.di

import com.example.solutionx.features.selection.data.repository.HelperLocalDSImp
import com.example.solutionx.features.selection.domain.repository.HelperLocalDs
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
