package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.Repository
import javax.inject.Inject

class LoginWithEmailUseCase @Inject constructor(
    private val repository: Repository,
) {
    operator fun invoke(email: String, password: String, ): User?{
        val request = repository.loginWithEmail(email, password)
        val token = request.accessToken
        repository.saveAccessToken(token)
        repository.saveUserInfo(token)
        return request.userInfo
    }

}