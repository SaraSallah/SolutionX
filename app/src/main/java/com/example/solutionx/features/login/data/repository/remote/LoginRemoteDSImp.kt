package com.example.solutionx.features.login.data.repository.remote

import android.util.Log
import com.example.solutionx.common.data.repository.remote.ApiServices
import com.example.solutionx.features.login.data.models.dto.LoginDto
import com.example.solutionx.features.login.domain.model.LoginRequest
import com.example.solutionx.features.login.domain.repository.remote.LoginRemoteDS
import com.example.solutionx.utils.SolutionXException
import com.example.solutionx.utils.getResponseType
import retrofit2.Response
import javax.inject.Inject

internal class LoginRemoteDSImp (
    private val loginServices: ApiServices,
) : LoginRemoteDS {
    override suspend fun loginWithEmail(email: String, password: String):
            LoginDto = LoginDto()

    override suspend fun loginWithPhone(
        loginRequest: LoginRequest
    ): LoginDto? {
        val request = loginServices.loginWithPhone(loginRequest)
        return request.body()
    }

    override suspend fun loginWithSocial(socialAcc: String): LoginDto = LoginDto()
    fun getResponseType(httpStatusCode: Int): SolutionXException {
        return when(httpStatusCode){
            ( 402) -> {
                SolutionXException.NetworkException("network error")
            }
            else -> SolutionXException.NotFoundException(" not found error")
        }

    }
}