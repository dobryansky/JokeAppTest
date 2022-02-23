package com.artem.jokeapptest

import android.app.Application
import com.artem.jokeapptest.resource_manager.BaseResourceManager

class JokeApp : Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseResourceManager(this)))

    }
}