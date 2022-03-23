package br.com.estudos.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.estudos.filmesflix.api.MovieRestApiTask
import br.com.estudos.filmesflix.model.Movie
import br.com.estudos.filmesflix.repository.MovieRepository
import java.lang.Exception

class MovieViewModel() : ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    // criando o objeto repository
    private val movieRepository = MovieRepository(movieRestApiTask)

    var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList



    fun init(){
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
        //postValue - trará os resultados depois de realizar o processamento - assíncrono
        _movieList.postValue(movieRepository.getAllMovies())
            } catch (e : Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }

}