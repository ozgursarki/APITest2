package com.ozgursarki.apitest2

import android.view.View
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Util {

    private val baseUrl = "https://restcountries.com/v3.1/"

    private var retrofit : Retrofit? = null

    fun getRetrofit(): Retrofit {
        return if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            retrofit as Retrofit
        }else{
            retrofit as Retrofit
        }
    }

    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.GONE
    }
}