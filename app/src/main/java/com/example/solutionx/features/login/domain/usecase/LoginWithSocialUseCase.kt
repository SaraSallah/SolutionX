package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.Repository
import javax.inject.Inject

class LoginWithSocialUseCase @Inject constructor(
    private val repository: Repository,
) {
    operator fun invoke(socialAcc: String, ): User? {
        val request = repository.loginWithSocial(socialAcc)
        val token = request.accessToken
        repository.saveAccessToken(token)
        repository.saveUserInfo(token)
        return request.userInfo

    }
}