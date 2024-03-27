package com.example.solutionx.common.data.repository.remote.services

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.QueryMap
import retrofit2.http.Url

internal interface RetrofitServices : NetworkServicesProvider {

    @POST
    override suspend fun <T, O> post(@Url url: String, @Body body: T): O

    @GET
    override suspend fun <O> Map<String, String>?.get(@Url url: String): O

    @DELETE
    override suspend fun <O> delete(@Url url: String, @QueryMap queryMap: Map<String, String>?): O
}


