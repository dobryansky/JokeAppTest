package com.artem.jokeapptest

import com.artem.jokeapptest.error_clases.JokeFailure
import com.artem.jokeapptest.input_clases.Joke

class ViewModel(private val model: Model) {

    private var callback: TextCallback?=null

    fun init( callback: TextCallback){
        this.callback = callback

        model.init(object :ResultCallback{
            override fun provideSuccess(data: Joke) {
                callback.provideText(data.getJokeUi())
                callback.provideUrl(data.getJokeUrl())
            }

            override fun provideError(error: JokeFailure) {
                callback.provideText(error.getMessage())
            }

        })
    }


    fun getJoke(){
        model.getJoke()
    }

    fun clear(){
        callback= null
        model.clear()
    }

}


interface TextCallback{
    fun provideText(text: String)
    fun provideUrl(url: String)
}