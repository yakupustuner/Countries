package com.learn.countries.repository


import com.learn.countries.api.Retrofit
import com.learn.countries.model.Country
import com.learn.countries.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class CRepository @Inject constructor(
    private val retrofit: Retrofit,
    ) {

    suspend fun getData(): Resource<List<Country>> {
        return try {
            val result = retrofit.getCountries()
            if (result.isSuccessful){
                result.body()?.let {
                    return@let Resource.Success(it)
                } ?: Resource.Error("Error",null)
            } else {
                Resource.Error("Error",null)
            }
        } catch (e:Exception){
            Resource.Error("Error",null)
        }
    }
}