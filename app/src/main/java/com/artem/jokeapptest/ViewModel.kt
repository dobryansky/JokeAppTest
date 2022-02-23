package com.artem.jokeapptest

class ViewModel(private val model: Model<Any,Any>) {

    private var callback: TextCallback?=null

    fun init( callback: TextCallback){
        this.callback = callback

        model.init(object :ResultCallback<Any,Any>{
            override fun provideSuccess(data: Any) {
                callback.provideText("SSS")
            }

            override fun provideError(error: Any) {
                callback.provideText("EEE")
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
}