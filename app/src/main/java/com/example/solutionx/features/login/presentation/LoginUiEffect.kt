package com.example.solutionx.features.login.presentation

sealed class LoginUiEffect {
     data object onClickLoginEffect : LoginUiEffect()
}
interface LoginInteractionListener{
     fun onClickLogin()
}