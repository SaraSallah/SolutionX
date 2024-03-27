package com.example.solutionx.common.data.repository.remote.services

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders.ContentType
import io.ktor.http.contentType

@Suppress("OVERRIDE_BY_INLINE")
class KtorLoginServices(val httpClient: HttpClient) : NetworkServicesProvider {

    //    override suspend fun <T, O> post(url: String, body: T): O {
//        return httpClient.post(url) {
//            contentType(ContentType.Application.Json)
//            this.body = body
//        }
//    }
//
//    override suspend inline fun <reified O> Map<String, String>?.get(url: String): O {
//        return if (this != null) {
//            httpClient.get {
//                url(url)
//                forEach { (key, value) ->
//                    parameter(key, value)
//                }
//            }
//        } else {
//            httpClient.get(url)
//        }
//    }
//
//    override suspend fun <O> delete(url: String, queryMap: Map<String, String>?): O {
//        return if (queryMap != null) {
//            httpClient.delete {
//                url(url)
//                queryMap.forEach { (key, value) ->
//                    parameter(key, value)
//                }
//            }
//        } else {
//            httpClient.delete(url)
//        }
//    }
    override suspend fun <T, O> post(url: String, body: T): O {
        TODO("Not yet implemented")
    }

    override suspend fun <O> Map<String, String>?.get(url: String): O {
        TODO("Not yet implemented")
    }

    override suspend fun <O> delete(url: String, queryMap: Map<String, String>?): O {
        TODO("Not yet implemented")
    }
}