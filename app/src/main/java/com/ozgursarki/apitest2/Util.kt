package com.ozgursarki.apitest2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Util {

    private val baseUrl = "https://restcountries.com/v3.1/"

    private var retrofit : Retrofit? = null

    fun getRetrofit(): Retrofit {
        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit as Retrofit
        }else{
            return retrofit as Retrofit
        }
    }
}