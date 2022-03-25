package br.com.fourvrstudios.aula6_retrofitdemo.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fourvrstudios.aula6_retrofitdemo.Network.Photo
import br.com.fourvrstudios.aula6_retrofitdemo.Network.RetrofitInstance
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

/* Classe para padronização de status */
enum class RestApiStatus { LOADING, ERROR, DONE }

class RetrofitViewModel : ViewModel() {

    /* LiveData do tipo RestApiStatus para armazenar os status */
    private val _status = MutableLiveData<RestApiStatus>()
    val status: LiveData<RestApiStatus>
        get() = _status

    private val _response = MutableLiveData<List<Photo>?>()
    val response: LiveData<List<Photo>?>
        get() = _response

    init {
        //getRestApiResponse()
        //getAllPhotos()
        getPhotosByAlbum()
        //postPhoto()
        //replacePhoto()
        //updatePhoto()
        //deletePhoto()
        // getRestApiResponse()
        //postField()
    }

    /* Forma Usando callbacks - Mais demorado
    private fun getRestApiResponse() {
        RetrofitInstance.retrofit.getAllCall().enqueue(object : Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    Log.i("RETROFIT_CALL", "Código da resposta: ${response.code()} - Registros retornados: ${response.body()?.size}")
                    _response.value = response.body()
                }
            }
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.i("RETROFIT_CALLL", "Falha: " + t.message)
            }
        })
    } */

    fun getAllPhotos(): Job =
        viewModelScope.launch {
            try {
                _status.value = RestApiStatus.LOADING
                _response.value = RetrofitInstance.retrofit.getAll().body()
                Log.i("MYTAG", "Success")
                _status.value = RestApiStatus.DONE
            } catch (e: IOException) {
                Log.i("MYTAG", "IOException - Sem Internet, URL incorreta, etc")
                _status.value = RestApiStatus.ERROR
                _response.value = null
            } catch (e: HttpException) {
                Log.i("MYTAG", "HttpException - Status Codes não iniciados com 2XX")
                _status.value = RestApiStatus.ERROR
                _response.value = null
            } catch (e: Exception) {
                Log.i("MYTAG", "Exceção Genérica")
                _status.value = RestApiStatus.ERROR
                _response.value = null
            }
        }

    fun getPhotosByAlbum() : Job = viewModelScope.launch {
        try {
            _status.value = RestApiStatus.LOADING
            _response.value = RetrofitInstance.retrofit.getPhotosByAlbumId(5).body()
            Log.i("MYTAG", "Success")
            _status.value = RestApiStatus.DONE
        } catch (e: java.lang.Exception) {
            _status.value = RestApiStatus.ERROR
            _response.value = null
        }

    }

    override fun onCleared() {
        super.onCleared()
        //getData().cancel() - As corrotinas em viewModelScope já são canceladas automaticamente.
    }
}