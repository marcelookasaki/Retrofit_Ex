package br.com.fourvrstudios.aula6_retrofitdemo.Network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

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

    // Salvar Foto – Necessário passar um objeto do tipo Photo como argumento
    @POST("photos")
    suspend fun salvarFoto(@Body minhaFoto: Photo): Response<Photo>

    // Salvar Foto – Necessário passar somente os parâmetros
    @FormUrlEncoded
    @POST("photos")
    suspend fun postPhotoField(
        @Field("albumId") myalbumId: Int,
        @Field("id") myId: Int,
        @Field("title") myTitle : String,
        @Field("url") myUrl : String,
        @Field("thumbnailUrl") mythumbnailUrl : String
    ) : Response<Photo>

    // Cria um novo objeto que substituirá outro existente (que tem o id indicado) SOBRESCREVE
    @PUT("photos/{id}")
    suspend fun overwritePhoto(@Path("id") id : Int, @Body foto: Photo) : Response<Photo>

    // Atualiza um objeto existente. Os campos enviados como "null" não irão sobrescrever os existentes
    @PATCH("photos/{id}")
    suspend fun patchPhoto(@Path("id") id : Int, @Body foto: Photo) : Response<Photo>
}