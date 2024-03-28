package com.example.solutionx.features.login.domain.usecase

import android.util.Log
import com.example.solutionx.features.login.domain.model.LoginRequest
import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.LoginRepository
import com.example.solutionx.common.utils.Resources
import com.example.solutionx.common.utils.SolutionXException
import com.example.solutionx.common.utils.wrapWithFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginWithPhoneUseCase (
    private val repository: LoginRepository,
) {
    suspend operator fun invoke(loginRequest: LoginRequest): Flow<Resources<User?>> {
        return wrapWithFlow {
            val request = repository.loginWithPhone(loginRequest)
            val token = request.accessToken
            repository.saveAccessToken(token)
            repository.saveUserInfo(request.userInfo)
            Log.e("Sara",repository.getUserInfo().toString())
            return@wrapWithFlow request.userInfo

        }
    }
}