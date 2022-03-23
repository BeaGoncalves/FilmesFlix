package br.com.estudos.filmesflix.repository

import android.util.Log
import br.com.estudos.filmesflix.api.MovieRestApiTask
import br.com.estudos.filmesflix.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG = "MovieRepository"
    }
    
    private val movieList = arrayListOf<Movie>()
    
    // funcao que irá pegar todos os filmes e exibir em uma lista
    fun getAllMovies() : List<Movie>{
        
        //criando o objeto retrofit e executando o webService
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