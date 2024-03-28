package com.example.solutionx.common.utils

sealed class Resources<out T>  {
    data class Success<T>(val data : T): Resources<T>()
    data class Failure(val exception  : SolutionXException): Resources<Nothing>()
     data class Loading(val isLoading : Boolean) : Resources<Nothing>()
    fun toData(): T? = if (this is Success) data else null


}

