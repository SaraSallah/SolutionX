package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.utils.Resources
import com.example.solutionx.utils.wrapWithFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginWithPhoneUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    suspend operator fun invoke(phone :String): Flow<Resources<User?>> {
        return wrapWithFlow {
            val request = repository.loginWithPhone(phone)
            val token = request.accessToken
            repository.saveAccessToken(token)
            repository.saveUserInfo(token)
            return@wrapWithFlow request.userInfo

        }
    }
}