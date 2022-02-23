package com.artem.jokeapptest.error_clases

import com.artem.jokeapptest.R
import com.artem.jokeapptest.resource_manager.ResourceManager

class NoConnection(private val resourceManager: ResourceManager):JokeFailure {
    override fun getMessage(): String =resourceManager.getString(R.string.no_connection)
}