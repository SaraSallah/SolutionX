package com.example.solutionx.features.login.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.features.login.domain.usecase.LoginWithEmailUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithPhoneUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithSocialUseCase
import com.example.solutionx.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithEmailUseCase: LoginWithEmailUseCase,
    private val loginWithPhoneUseCase: LoginWithPhoneUseCase,
    private val loginWithSocialUseCase: LoginWithSocialUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun loginWithEmail(email: String, password: String) {
        viewModelScope.launch {
            loginWithEmailUseCase.invoke(email, password).collect { resource ->
                when (resource) {
                    is Resources.Loading -> {
                        _state.update { it.copy(isLoading = true) }
                    }

                    is Resources.Success -> {
                        val user = resource.data
                        _state.update { it.copy(userInfo = user!!.toUserUiState()) }
                    }

                    is Resources.Failure -> {
                        _state.update { it.copy(isError = true) }
                    }
                }
            }


        }


    }

    suspend fun loginWithPhoneNumber(phone: String) {
        loginWithPhoneUseCase.invoke(phone)
    }

    suspend fun loginWithSocialAcc(socialAcc: String) {
        loginWithSocialUseCase.invoke(socialAcc)
    }
}