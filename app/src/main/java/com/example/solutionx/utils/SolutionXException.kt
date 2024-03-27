package com.example.solutionx.utils

import android.util.Log
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Response
import java.io.IOException
import java.sql.SQLException


sealed class SolutionXException(message: String? = null) : Exception(message){
    data class NetworkException(override val message: String?) : SolutionXException()

    data class DatabaseException(override val message: String?) : SolutionXException()
    data class NotFoundException (override val message: String?) : SolutionXException()
    data class UnAuthorizedException (override val message: String?) : SolutionXException()

    data class ApiException(override val message: String?) : SolutionXException()

}





fun <T> wrapWithFlow(function: suspend () -> T): Flow<Resources<T>> {
    return flow {
        emit(Resources.Loading(true))
        try {
            val result = function()
            emit(Resources.Success(result))
            emit(Resources.Loading(false))

        } catch (e: Exception) {
            emit(Resources.Failure(getExceptionType(e)))

            emit(Resources.Loading(false))

        }
        }
    }
fun getExceptionType(e :Exception) :SolutionXException{
    return when(e){
        is IOException -> SolutionXException.NetworkException("Network error occurred")
        is SQLException -> SolutionXException.DatabaseException(e.message)
        is android.content.res.Resources.NotFoundException -> SolutionXException.NotFoundException(" Not Found Exception")
        else -> SolutionXException.ApiException(e.message)
    }

}
fun getResponseType(httpStatusCode: Int):SolutionXException{
    return when(httpStatusCode){
        ( 502) -> SolutionXException.NetworkException("")
        else ->SolutionXException.NotFoundException("")
    }

}




