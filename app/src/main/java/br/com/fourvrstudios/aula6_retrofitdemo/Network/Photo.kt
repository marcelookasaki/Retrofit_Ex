package br.com.fourvrstudios.aula6_retrofitdemo.Network

import com.squareup.moshi.Json

data class Photo(
    @Json(name = "albumId")
    val albumId: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String?,
    @Json(name = "title")
    var title: String,
    @Json(name = "url")
    val url: String
)