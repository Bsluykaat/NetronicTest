package com.kerumitbsl.core.components.rest

import com.kerumitbsl.core.bean.response.GetUsersResponse
import com.kerumitbsl.core.extensions.SEED
import retrofit2.http.GET
import retrofit2.http.Query

interface TestTaskApi {

    @GET("api/")
    fun getUsers(
        @Query("results") results: Int,
        @Query("format") format: String = "json",
        @Query("inc") inc: String = "gender,name,email,dob,picture,id,nat",
        @Query("page") page: Int,
        @Query("seed") seed: String = SEED
    ): GetUsersResponse
}