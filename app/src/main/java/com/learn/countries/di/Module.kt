package com.learn.countries.di

import android.content.Context
import com.learn.countries.App
import com.learn.countries.api.Retrofit
import com.learn.countries.repository.CRepository
import com.learn.countries.util.Util.BASE_URL
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext application : Context): App {
        return application as App
    }
    @Singleton
    @Provides
    fun injectRetrofit(): Retrofit {
        return retrofit2.Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(Retrofit::class.java)
    }
    @Singleton
    @Provides
    fun injectRe(api: Retrofit) = CRepository(api)
}