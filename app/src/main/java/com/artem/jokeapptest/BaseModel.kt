package com.artem.jokeapptest

import com.artem.jokeapptest.error_clases.NoConnection
import com.artem.jokeapptest.error_clases.ServiceUnavailable
import com.artem.jokeapptest.resource_manager.BaseResourceManager
import com.artem.jokeapptest.service.JokeService
import retrofit2.Call
import retrofit2.Response
import java.net.UnknownHostException
import javax.security.auth.callback.Callback

class BaseModel(
    private val service: JokeService,
    private val resourceManager: BaseResourceManager
) : Model {
    private var callback: ResultCallback? = null
    private val noConnection by lazy { NoConnection(resourceManager) }
    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }


    override fun getJoke() {
       service.getJoke().enqueue(object: retrofit2.Callback<JokeDTO>{
           override fun onResponse(call: Call<JokeDTO>, response: Response<JokeDTO>) {
               if(response.isSuccessful){
                   callback?.provideSuccess(response.body()!!.toJoke())
               }else{
                   callback?.provideError(serviceUnavailable)
               }
           }

           override fun onFailure(call: Call<JokeDTO>, t: Throwable) {
             if(t is UnknownHostException)
                 callback?.provideError(noConnection)
               else
                   callback?.provideError(serviceUnavailable)
           }

       })
    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }
}