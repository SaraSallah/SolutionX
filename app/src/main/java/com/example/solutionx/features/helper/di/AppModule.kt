package com.example.solutionx.features.helper.di

import android.app.Application
import android.content.Context
import com.example.solutionx.features.helper.data.repository.HelperLocalDSImp
import com.example.solutionx.features.helper.domain.repository.HelperLocalDs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideDataBase(context: Context): HelperLocalDs {
        return HelperLocalDSImp(context)
    }
}

