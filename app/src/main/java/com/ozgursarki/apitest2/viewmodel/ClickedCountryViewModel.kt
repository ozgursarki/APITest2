package com.ozgursarki.apitest2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozgursarki.apitest2.CountryAPI
import com.ozgursarki.apitest2.Util
import com.ozgursarki.apitest2.model.ClickedFlag
import com.ozgursarki.apitest2.model.Countries
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class ClickedCountryViewModel(application:Application): AndroidViewModel(application) {

    val infoFlag : MutableLiveData<ArrayList<ClickedFlag>> by lazy {
        MutableLiveData<ArrayList<ClickedFlag>>()
    }

    private var retrofit : Retrofit = Util.getRetrofit()

    val api = retrofit.create(CountryAPI::class.java)

    fun getFlagsInfo(name : String) {
        viewModelScope.launch {
            val info = api.getCountriesInfo(name)
            infoFlag.value = info
        }
    }

}