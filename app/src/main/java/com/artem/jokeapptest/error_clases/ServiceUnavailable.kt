package com.artem.jokeapptest.error_clases

import com.artem.jokeapptest.R
import com.artem.jokeapptest.resource_manager.ResourceManager

class ServiceUnavailable(private val resourceManager: ResourceManager):JokeFailure {
    override fun getMessage(): String=resourceManager.getString(R.string.service_unavailable)
}