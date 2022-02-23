package com.artem.jokeapptest


import com.artem.jokeapptest.input_clases.Joke
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



data class JokeDTO(
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("value")
    val value: String
){
    fun toJoke()= Joke(iconUrl,value)
}