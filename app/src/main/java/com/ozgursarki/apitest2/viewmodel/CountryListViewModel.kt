package com.ozgursarki.apitest2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozgursarki.apitest2.domain.repository.MyRepository
import com.ozgursarki.apitest2.model.Countries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel@Inject constructor(application: Application,private val repository: MyRepository) : AndroidViewModel(application){

    val countries: MutableLiveData<ArrayList<Countries>> by lazy {
        MutableLiveData<ArrayList<Countries>>()
    }

    fun getCountryName(){
        viewModelScope.launch {
            val country: ArrayList<Countries> = repository.getCountries()
            countries.value = country
        }
    }




}