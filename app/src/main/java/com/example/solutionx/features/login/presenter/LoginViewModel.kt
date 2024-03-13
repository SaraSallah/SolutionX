package com.example.solutionx.features.login.presenter

import androidx.lifecycle.ViewModel
import com.example.solutionx.features.login.domain.model.Login
import com.example.solutionx.features.login.domain.usecase.LoginWithEmailUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithPhoneUseCase
import com.example.solutionx.features.login.domain.usecase.LoginWithSocialUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginWithEmailUseCase: LoginWithEmailUseCase,
    private val loginWithPhoneUseCase: LoginWithPhoneUseCase,
    private val loginWithSocialUseCase: LoginWithSocialUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun loginWithEmail(email:String , password : String){
        loginWithEmailUseCase.invoke(email,password)
    }
    fun loginWithPhoneNumber(phone:String){
        loginWithPhoneUseCase.invoke(phone)
    }
    fun loginWithSocialAcc(socialAcc : String){
        loginWithSocialUseCase.invoke(socialAcc)
    }
}