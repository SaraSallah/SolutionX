package com.example.solutionx.features.login.presenter

sealed class LoginUiEffect {
     object onClickLoginEffect : LoginUiEffect()
}
interface LoginInteractionListener{
     fun onClickLogin()
}