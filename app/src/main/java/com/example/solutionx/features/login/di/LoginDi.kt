package com.example.solutionx.features.login.di

import android.content.Context
import com.example.solutionx.common.data.repository.remote.ApiServices
import com.example.solutionx.common.di.NetworkModule_ProvideRetrofitFactory.provideRetrofit
import com.example.solutionx.features.login.data.repository.LoginRepositoryImp
import com.example.solutionx.features.login.data.repository.local.LoginDataStorePreferences
import com.example.solutionx.features.login.data.repository.local.LoginLocalDSImp
import com.example.solutionx.features.login.data.repository.remote.LoginRemoteDSImp
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import com.example.solutionx.features.login.domain.repository.remote.LoginRemoteDS
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.features.login.domain.usecase.LoginWithEmailUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithPhoneUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithPhoneUseCase_Factory
import com.example.solutionx.features.login.domain.usecase.LoginWithSocialUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal object LoginDi {

    @Provides
    fun provideLoginDataStore(context: Context): LoginDataStorePreferences {
        return LoginDataStorePreferences(context)
    }
    @Provides
    fun provideRemoteDS(apiServices: ApiServices):LoginRemoteDS{
        return LoginRemoteDSImp(apiServices)
    }

    @Provides
    fun provideLocalDs(loginDataStore: LoginDataStorePreferences): LoginLocalDS {
        return LoginLocalDSImp(loginDataStore)}

    @Provides
    fun provideRepository(remoteDS: LoginRemoteDS, localDS: LoginLocalDS): LoginRepository =
        LoginRepositoryImp(remoteDS, localDS)

    @Provides
    fun provideLoginWithEmailUseCase(repository: LoginRepository): LoginWithEmailUseCase =
        LoginWithEmailUseCase(repository)
    @Provides
    fun provideLoginWithPhoneUseCase(repository: LoginRepository): LoginWithPhoneUseCase =
        LoginWithPhoneUseCase(repository)

    @Provides
    fun provideLoginWithSocialUseCase(repository: LoginRepository): LoginWithSocialUseCase =
        LoginWithSocialUseCase(repository)
}