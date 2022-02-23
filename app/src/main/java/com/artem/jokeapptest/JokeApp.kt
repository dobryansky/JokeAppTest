package com.artem.jokeapptest

import android.app.Application
import com.artem.jokeapptest.resource_manager.BaseResourceManager
import com.artem.jokeapptest.service.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseResourceManager(this)))


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/random/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viewModel = ViewModel(BaseModel(retrofit.create(JokeService::class.java), BaseResourceManager(this)))

    }
}