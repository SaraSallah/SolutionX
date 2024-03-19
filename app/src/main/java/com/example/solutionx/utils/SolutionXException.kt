package com.example.solutionx.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Response
import java.io.IOException
import java.sql.SQLException


open class SolutionXException(message: String? = null)
    : Exception(message)



class NetworkException(override val message: String?) : SolutionXException()

class DatabaseException(override val message: String?) : SolutionXException()
class NotFoundException (override val message: String?) : SolutionXException()
class UnAuthorizedException (override val message: String?) : SolutionXException()

class ApiException(override val message: String?) : SolutionXException()

fun <T> wrapWithFlow(function: suspend () -> T): Flow<Resources<T>> {
    return flow {
        emit(Resources.Loading)
        try {
            val result = function()
            emit(Resources.Success(result))
        } catch (e: Exception) {
            emit(Resources.Failure(getExceptionType(e)))

            }
        }
    }
fun getExceptionType(e :Exception) :SolutionXException{
    return when(e){
        is IOException -> NetworkException("Network error occurred")
        is SQLException -> DatabaseException(e.message)
        is android.content.res.Resources.NotFoundException -> NotFoundException(" Not Found Exception")
        else -> ApiException(e.message)
    }
}




