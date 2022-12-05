package com.ozgursarki.apitest2

import com.ozgursarki.apitest2.model.CountryLang
import com.ozgursarki.apitest2.model.CountryName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryAPI {

    @GET("name/{name}")
    suspend fun getCountryName(): CountryName

    @GET("currency/{currency}")
    suspend fun getCountryLang(): CountryLang
}