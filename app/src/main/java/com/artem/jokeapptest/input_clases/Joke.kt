package com.artem.jokeapptest.input_clases

class Joke(private val url: String, private val text: String) {
    fun getJokeUi() = "$text"
    fun getJokeUrl() = url

}