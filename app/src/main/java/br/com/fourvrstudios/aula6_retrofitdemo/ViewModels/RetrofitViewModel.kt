package br.com.fourvrstudios.aula6_retrofitdemo.ViewModels

import androidx.lifecycle.ViewModel


class RetrofitViewModel : ViewModel() {

/*    private val _response = MutableLiveData<List<Photo>?>()
    val response: LiveData<List<Photo>?>
        get() = _response */

    init {
        //getRestApiResponse()
        //getAllPhotos()
        //getPhotosByAlbum()
        //postPhoto()
        //replacePhoto()
        //updatePhoto()
        //deletePhoto()
        // getRestApiResponse()
        //postField()
    }

    override fun onCleared() {
        super.onCleared()
        //getData().cancel() - As corrotinas em viewModelScope já são canceladas automaticamente.
    }
}