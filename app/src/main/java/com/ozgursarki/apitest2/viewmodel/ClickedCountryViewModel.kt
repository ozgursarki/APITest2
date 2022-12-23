package com.ozgursarki.apitest2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozgursarki.apitest2.domain.repository.MyRepository
import com.ozgursarki.apitest2.model.ClickedFlag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClickedCountryViewModel@Inject constructor(application:Application, private val repository: MyRepository): AndroidViewModel(application) {

    val infoFlag : MutableLiveData<ArrayList<ClickedFlag>> by lazy {
        MutableLiveData<ArrayList<ClickedFlag>>()
    }

    fun getDetails(name:String){
        viewModelScope.launch {
            val details = repository.getCountriesInfo(name)
            infoFlag.value = details
        }
    }




}