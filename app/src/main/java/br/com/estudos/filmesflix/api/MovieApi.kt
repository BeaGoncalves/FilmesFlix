package br.com.estudos.filmesflix.api

import br.com.estudos.filmesflix.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovie(): Call<List<Movie>>
}