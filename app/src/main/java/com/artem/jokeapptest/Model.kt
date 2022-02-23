package com.artem.jokeapptest

import com.artem.jokeapptest.error_clases.JokeFailure
import com.artem.jokeapptest.input_clases.Joke

interface Model {
    fun getJoke()
    fun init(callback: ResultCallback)
    fun clear()
}

interface ResultCallback {
    fun provideSuccess(data: Joke)
    fun provideError(error: JokeFailure)
}