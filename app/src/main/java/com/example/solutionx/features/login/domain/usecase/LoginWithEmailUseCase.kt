package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.utils.Resources
import com.example.solutionx.utils.wrapWithFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class LoginWithEmailUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    suspend operator fun invoke(email: String, password: String): Flow<Resources<User?>> {
        return wrapWithFlow {
            val request = repository.loginWithEmail(email, password)
            val token = request.accessToken
            repository.saveAccessToken(token)
            repository.saveUserInfo(token)
            return@wrapWithFlow request.userInfo
        }
    }
}