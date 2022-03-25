package br.com.estudos.filmesflix.implementation

import android.util.Log
import br.com.estudos.filmesflix.framework.f.api.MovieRestApiTask
import br.com.estudos.filmesflix.data.MovieDataSource
import br.com.estudos.filmesflix.domain.Movie


class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) : MovieDataSource {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMoviesFromApi(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovie().execute()

        //verifica se a solicitacao foi sucedida ou deu falha
        if (request.isSuccessful) {
            //body() irá retornar toda a lista de filme
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }

        }
        return movieList
    }
}