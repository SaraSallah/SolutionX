package com.example.solutionx.features.selection.di

import com.example.solutionx.features.selection.data.repository.HelperRepositoryImp
import com.example.solutionx.features.selection.domain.repository.HelperRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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

