package com.example.solutionx.features.login.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.features.login.domain.model.LoginRequest
import com.example.solutionx.features.login.domain.usecase.LoginWithEmailUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithPhoneUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithSocialUseCase
import com.example.solutionx.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithEmailUseCase: LoginWithEmailUseCase,
    private val loginWithPhoneUseCase: LoginWithPhoneUseCase,
    private val loginWithSocialUseCase: LoginWithSocialUseCase,
) : ViewModel(),LoginInteractionListener {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()


    protected val _effect = MutableSharedFlow<LoginUiEffect>()
    val effect = _effect.asSharedFlow()

     override fun onClickLogin() {
         loginWithPhoneNumber()
    }

    private fun loginWithPhoneNumber() {
        viewModelScope.launch(Dispatchers.IO) {
            val loginRequest = LoginRequest(
                _state.value.countryCode.trim(),
                _state.value.phoneNumber.trim(),
                _state.value.password.trim()
            )
            loginWithPhoneUseCase.invoke(loginRequest).collect { resource ->
                when (resource) {
                    is Resources.Loading -> _state.update { it.copy(isLoading = true) }
                    is Resources.Success -> {

                        _effect.emit(LoginUiEffect.onClickLoginEffect)
                        Log.e("ٍSara", "Login Sucecce")

                    }

                    is Resources.Failure -> {
                        _state.update { it.copy(isError = true) }
                        Log.e("ٍSara", "Login failed")
                    }

                }


                }
            }
        }


    fun onPhoneNumberInputChange(phoneNumber: CharSequence) {
        _state.update { it.copy(phoneNumber = phoneNumber.trim().toString()) }
    }

    fun onPasswordInputChanged(password: CharSequence) {
        _state.update { it.copy(password = password.trim().toString()) }
    }

    fun onCountryCodeInputChanged(countryCode: CharSequence) {
        _state.update { it.copy(countryCode = countryCode.trim().toString()) }
    }

}