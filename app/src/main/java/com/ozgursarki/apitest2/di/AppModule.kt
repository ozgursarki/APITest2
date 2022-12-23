package com.ozgursarki.apitest2.di


import com.ozgursarki.apitest2.domain.repository.MyRepository
import com.ozgursarki.apitest2.CountryAPI
import com.ozgursarki.apitest2.data.repository.MyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRetrofit(): CountryAPI{
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryAPI::class.java)
    }

    @Provides
    @Singleton
    fun getRepository(api: CountryAPI): MyRepository  {
        return MyRepositoryImpl(api)
    }
}