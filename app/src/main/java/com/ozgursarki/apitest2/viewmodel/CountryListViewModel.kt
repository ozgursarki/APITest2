package com.ozgursarki.apitest2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozgursarki.apitest2.CountryAPI
import com.ozgursarki.apitest2.Util
import com.ozgursarki.apitest2.model.Countries
import com.ozgursarki.apitest2.model.CountryLang
import com.ozgursarki.apitest2.model.CountryName
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class CountryListViewModel(application: Application) : AndroidViewModel(application){

    val countries: MutableLiveData<ArrayList<Countries>> by lazy {
        MutableLiveData<ArrayList<Countries>>()
    }

    private var retrofit : Retrofit = Util.getRetrofit()


    val api = retrofit.create(CountryAPI::class.java)

    fun getCountryName(){
        viewModelScope.launch {
            val country: ArrayList<Countries> = api.getCountries()
            countries.value = country
        }
    }


}