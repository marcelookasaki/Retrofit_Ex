package br.com.fourvrstudios.aula6_retrofitdemo.Network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    /* Este método irá concatenar photos com a base url, resultando em
https://jsonplaceholder.typicode.com/photos */
    @GET("photos") //anotação relativa ao método GET do Retrofit
    fun getAllCall(): Call<List<Photo>>
}