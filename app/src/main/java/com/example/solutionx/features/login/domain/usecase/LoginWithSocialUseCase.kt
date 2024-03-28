package com.example.solutionx.features.login.domain.usecase

import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.common.utils.Resources
import com.example.solutionx.common.utils.wrapWithFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginWithSocialUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    suspend operator fun invoke(socialAcc: String ): Flow<Resources<User?>> {
        return wrapWithFlow {
            val request = repository.loginWithSocial(socialAcc)
            val token = request.accessToken
            repository.saveAccessToken(token.orEmpty())
            repository.saveUserInfo(request.userInfo)
            return@wrapWithFlow request.userInfo

        }
    }
}