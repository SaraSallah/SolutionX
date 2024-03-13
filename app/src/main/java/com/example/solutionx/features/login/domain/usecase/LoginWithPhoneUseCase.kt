package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LoginRepository
import javax.inject.Inject

class LoginWithPhoneUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    operator fun invoke(phone: String): User? {
        val request = repository.loginWithPhone(phone)
        val token = request.accessToken
        repository.saveAccessToken(token)
        repository.saveUserInfo(token)
        return request.userInfo
    }
}