package com.example.solutionx.features.selection.di

import android.content.Context
import com.example.solutionx.features.selection.data.repository.HelperLocalDSImp
import com.example.solutionx.features.selection.domain.repository.HelperLocalDs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun provideDataBase(context: Context): HelperLocalDs {
        return HelperLocalDSImp(context)
    }
}

