package com.example.solutionx.features.login.presenter

sealed class LoginUiEffect {
     data object onClickLoginEffect : LoginUiEffect()
}
interface LoginInteractionListener{
     fun onClickLogin()
}