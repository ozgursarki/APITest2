package com.ozgursarki.apitest2.domain.repository

import com.ozgursarki.apitest2.model.Country
import com.ozgursarki.apitest2.model.InfoClickedFlag
import retrofit2.http.Path

interface MyRepository {


    suspend fun getCountries(): Country


    suspend fun getCountriesInfo(@Path("name") name : String) : InfoClickedFlag
}