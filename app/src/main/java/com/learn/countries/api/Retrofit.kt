package com.learn.countries.api

import com.learn.countries.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface Retrofit {
    @GET("")
    suspend fun getCountries():Response<List<Country>>

}