package br.com.estudos.filmesflix.framework.f.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.estudos.filmesflix.framework.f.api.MovieRestApiTask
import br.com.estudos.filmesflix.data.MovieRepository
import br.com.estudos.filmesflix.domain.Movie
import br.com.estudos.filmesflix.implementation.MovieDataSourceImplementation
import br.com.estudos.filmesflix.usecase.MovieListUseCase
import java.lang.Exception

class MovieViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }


    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    // criando o objeto repository
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList



    fun init(){
        todosOsFilmes()
    }

//    private fun getAllMovies() {
//        Thread.sleep(2000)
//        Thread{
//            try {
//        //postValue - trará os resultados depois de realizar o processamento - assíncrono
//        _movieList.postValue(movieListUseCase.invoke())
//            } catch (e : Exception) {
//                Log.d(TAG, e.message.toString())
//            }
//        }.start()
//    }
//
    private fun todosOsFilmes() {
        Thread{
            try {
                _movieList.postValue(movieListUseCase.invoke())
            } catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}