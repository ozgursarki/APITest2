package com.ozgursarki.apitest2.data.repository

import com.ozgursarki.apitest2.domain.repository.MyRepository
import com.ozgursarki.apitest2.model.Country
import com.ozgursarki.apitest2.model.InfoClickedFlag
import com.ozgursarki.apitest2.data.remote.CountryAPI
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: CountryAPI
        ) : MyRepository {
    override suspend fun getCountries(): Country {
        return api.getCountries()
    }

    override suspend fun getCountriesInfo(name: String): InfoClickedFlag {
        return api.getCountriesInfo(name)
    }
}