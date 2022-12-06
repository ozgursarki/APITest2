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
    val currentName: MutableLiveData<CountryName> by lazy {
        MutableLiveData<CountryName>()
    }

    val currentLang: MutableLiveData<CountryLang> by lazy {
        MutableLiveData<CountryLang>()
    }

    val api = retrofit.create(CountryAPI::class.java)

    fun getCountryName(){
        viewModelScope.launch {
  //          val response = api.getCountryName()
  //          currentName.value = response
        }
    }

    fun getCountryLang(){
        viewModelScope.launch {
   //         val response2 = api.getCountryLang()
   //         currentLang.value = response2
        }
    }

    fun getAllCountries(){
        viewModelScope.launch {
            val country = api.getCountries()
            countries.value = country
        }
    }
}