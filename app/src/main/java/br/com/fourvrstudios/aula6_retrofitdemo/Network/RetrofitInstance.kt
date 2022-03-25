package br.com.fourvrstudios.aula6_retrofitdemo.Network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Inicializando o Moshi - A nossa Converter Factory
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// MÉTODO 1
class RetrofitInstance {
    companion object { // Compantion object para que a instancia do retrofit esteja acessível na aplicação
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // URL base
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // Conversor de Json em objetos Kotlin // Podemos utilizar o .asLenient() para nullable
            .build() // Cria o Retrofit Object
            .create(ApiService::class.java) // Interface onde estarão configurados os métodos HTTP
    }
}