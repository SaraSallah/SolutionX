package com.example.solutionx.utils

sealed class Resources<out T>  {
    data class Success<T>(val data : T):Resources<T>()
    data class Failure(val exception  :SolutionXException ):Resources<Nothing>()
     data class Loading(val isLoading : Boolean) :Resources<Nothing>()
}

