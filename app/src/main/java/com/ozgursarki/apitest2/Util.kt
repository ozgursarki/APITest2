package com.ozgursarki.apitest2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Util {

    private const val baseUrl = "https://restcountries.com/v3.1/"

    private var retrofit : Retrofit? = null

    fun getRetrofit(): Retrofit {
        return if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            retrofit as Retrofit
        }else{
            retrofit as Retrofit
        }
    }
}