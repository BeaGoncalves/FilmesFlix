package br.com.estudos.filmesflix.framework.f.api

import br.com.estudos.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovie(): Call<List<Movie>>
}