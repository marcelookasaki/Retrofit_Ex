package br.com.fourvrstudios.aula6_retrofitdemo.Network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    /* Este método irá concatenar photos com a base url, resultando em https://jsonplaceholder.typicode.com/photos */
    @GET("photos") //anotação relativa ao método GET do Retrofit
    fun getAllCall(): Call<List<Photo>>

    @GET("photos")
    suspend fun getAll() : Response<List<Photo>>

    // Método que gera a seguinte url: "https://jsonplaceholder.typicode.com/photos?albumId=idAlbum
    @GET("photos")
    suspend fun getPhotosByAlbumId(@Query("albumId") idAlbum: Int): Response<List<Photo>>

    /* Método que retorna apenas um elemento */
    @GET("photos/{id}")
    suspend fun getByIdPath(@Path("id") meuId: Int) : Response<Photo>
}