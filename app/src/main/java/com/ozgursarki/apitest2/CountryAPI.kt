package com.ozgursarki.apitest2

import com.ozgursarki.apitest2.model.Country
import com.ozgursarki.apitest2.model.CountryLang
import com.ozgursarki.apitest2.model.CountryName
import com.ozgursarki.apitest2.model.InfoClickedFlag
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

sealed interface CountryAPI {

    @GET("all")
    suspend fun getCountries(): Country

    @GET("name/{name}")
    suspend fun getCountriesInfo(@Path("name") name : String) : InfoClickedFlag

}