package com.ozgursarki.apitest2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozgursarki.apitest2.CountryAPI
import com.ozgursarki.apitest2.Resource
import com.ozgursarki.apitest2.Util
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.CountryLang
import com.ozgursarki.apitest2.model.CountryName
import com.ozgursarki.apitest2.model.Name
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class CountryListViewModel(application: Application) : AndroidViewModel(application){

    val countries: MutableLiveData<ArrayList<Countries>> by lazy {
        MutableLiveData<ArrayList<Countries>>()
    }


    private var retrofit : Retrofit = Util.getRetrofit()


    val api = retrofit.create(CountryAPI::class.java)

    fun getCountryName() = viewModelScope.launch {
        val countryDeferred = async { api.getCountries() }
        val flagsDeferred = async { api.getCountries() }

        val countries = countryDeferred.await()
        val flags = flagsDeferred.await()

        val startDestItems = mutableListOf<Countries>()
        if (countries is Resource.Success<*> && flags is Resource.Success {
            startDestItems.addAll(countries.value as Collection<Countries>)
            startDestItems.addAll(flags.value as Collection<Countries>)
            startDestItems.add(Countries.Flags())
        }

    }


}