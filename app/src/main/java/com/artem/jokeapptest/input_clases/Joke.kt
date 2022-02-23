package com.artem.jokeapptest.input_clases

class Joke(private val text: String, private val id: String) {
    fun getJokeUi() = "$text"

}