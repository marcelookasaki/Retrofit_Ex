package br.com.fourvrstudios.aula6_retrofitdemo.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fourvrstudios.aula6_retrofitdemo.Network.Photo
import br.com.fourvrstudios.aula6_retrofitdemo.Network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitViewModel : ViewModel() {

    private val _response = MutableLiveData<List<Photo>?>()
    val response: LiveData<List<Photo>?>
        get() = _response
    
    init {
        getRestApiResponse()
        //getAllPhotos()
        //getPhotosByAlbum()
        //postPhoto()
        //replacePhoto()
        //updatePhoto()
        //deletePhoto()
        // getRestApiResponse()
        //postField()
    }

    private fun getRestApiResponse() {
        RetrofitInstance.retrofit.getAllCall().enqueue(object : Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    Log.i("RETROFIT_CALL", "Código da resposta: ${response.code()} - Registros retornados: ${response.body()?.size}")
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.i("RETROFIT_CALLL", "Falha: " + t.message)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        //getData().cancel() - As corrotinas em viewModelScope já são canceladas automaticamente.
    }
}